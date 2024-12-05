package com.sunny.sportwomen.util;


import io.minio.*;
import io.minio.errors.*;
import io.minio.http.Method;
import io.minio.messages.Item;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Slf4j
public class MinIOUtil {

    @SneakyThrows
    public void createBucket(MinioClient client, String bucketName) {
        boolean exists = client.bucketExists(
                BucketExistsArgs.builder()
                        .bucket(bucketName)
                        .build()
        );

        if (!exists) {
            client.makeBucket(
                    MakeBucketArgs.builder().
                            bucket(bucketName).
                            build()
            );
            log.debug("bucket {} created", bucketName);
        } else {
            log.warn("bucket {} already exists", bucketName);
        }
    }

    @SneakyThrows
    public void removeBucket(MinioClient client, String bucketName) {
        client.removeBucket(
                RemoveBucketArgs.builder()
                        .bucket(bucketName)
                        .build()
        );
        log.debug("bucket {} removed", bucketName);
    }

    @SneakyThrows
    public StatObjectResponse getObjectInfo(MinioClient client, String bucketName, String objectName) {
        return client.statObject(
                StatObjectArgs.builder()
                        .bucket(bucketName)
                        .object(objectName).build()
        );
    }

    @SneakyThrows
    public boolean folderExists(MinioClient client, String bucketName, String prefix) {
        Iterable<Result<Item>> results = client.listObjects(
                ListObjectsArgs.builder()
                        .bucket(bucketName)
                        .prefix(prefix)
                        .recursive(false)
                        .build()
        );

        return StreamSupport.stream(results.spliterator(), false)
                .anyMatch(itemResult -> {
                    try {
                        return itemResult.get().isDir();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                });
    }

    @SneakyThrows
    public void createFolder(MinioClient client, String bucketName, String folderName) {
        client.putObject(
                PutObjectArgs.builder()
                        .bucket(bucketName)
                        .object(folderName + "/")
                        .stream(null, 0, -1)
                        .build()
        );
    }

    @SneakyThrows
    public String getObjectUrl(MinioClient client, String bucketName, String objectName) {
        return client.getPresignedObjectUrl(
                GetPresignedObjectUrlArgs.builder()
                        .method(Method.GET)
                        .bucket(bucketName)
                        .object(objectName)
                        .build()
        );
    }
}
