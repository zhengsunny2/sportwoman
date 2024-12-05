package com.sunny.sportwomen.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("video_info")
public class VideoInfo {

    private Integer id;

    private String title;

    // 描述
    private String description;

    private String tags;

    private String authorName;

    private Integer authorId;

    private String videoUrl;

    private String coverUrl;

    // 视频时长 秒
    private Integer duration;

    // 播放计数
    private Integer playCount;

    // 评论计数
    private Integer commentCount;

    private LocalDateTime uploadTime;
}
