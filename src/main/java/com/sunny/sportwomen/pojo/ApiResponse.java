package com.sunny.sportwomen.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author YangFan
 * @version 1.0
 * @date 2021/4/30 15:05
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse<T> implements Serializable {

    private static final long serialVersionUID = -8987146499044811408L;

    /**
     * 通用返回状态
     */
    private ApiResponseCode code;

    /**
     * 通用返回信息
     */
    private String msg;

    private boolean success;

    /**
     * 通用返回数据
     */
    private T data;

    public static <T> ApiResponse<T> buildSuccess(T data){
        return buildSuccess(ApiResponseCode.OK, data, null);
    }

    public static <T> ApiResponse<T> buildSuccess(T data, String msg){
        return buildSuccess(ApiResponseCode.OK, data, msg);
    }

    /**
     * 接口调用成功
     * @param code
     * @param data
     * @param msg
     * @param <T>
     * @return
     */
    public static <T> ApiResponse<T> buildSuccess(ApiResponseCode code, T data, String msg){
        return ApiResponse.<T>builder()
                .code(code)
                .success(true)
                .data(data)
                .msg(msg)
                .build();
    }

    /**
     * 构建失败的api数据
     * @param code
     * @param msg
     * @return
     */
    public static <T> ApiResponse<T> buildFail(ApiResponseCode code, String msg) {
        return ApiResponse.<T>builder()
                .code(code)
                .msg(msg)
                .success(false)
                .build();
    }
}
