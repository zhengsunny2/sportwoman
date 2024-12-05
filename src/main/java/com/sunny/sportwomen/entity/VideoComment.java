package com.sunny.sportwomen.entity;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 视频评论
 */
@Data
public class VideoComment {

    private Integer id;

    private Integer videoId;

    private Integer authorId;

    private String authorName;

    private String content;

    private LocalDateTime createTime;
}
