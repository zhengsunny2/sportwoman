package com.sunny.sportwomen.controller;

import com.sunny.sportwomen.entity.VideoInfo;
import com.sunny.sportwomen.pojo.ApiResponse;
import com.sunny.sportwomen.pojo.PageVO;
import com.sunny.sportwomen.services.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/video")
public class VideoController {

    @Autowired
    private VideoService videoService;

    /**
     * 获取视频列表
     * @return VideoListVO
     */
    // TODO 参数列表，分页参数，tag 查询
    @GetMapping("/list")
    public ApiResponse<PageVO<VideoInfo>> list(
            @RequestParam(required = false) String tag,
            @RequestParam(required = false, defaultValue = "1") Integer page,
            @RequestParam(required = false, defaultValue = "10") Integer pageSize
    ) {
        return videoService.list(tag, page, pageSize);
    }

    /**
     * 获取视频详情
     * @return VideoInfoVO
     */
    @GetMapping("/detail/{videoId}")
    public ApiResponse<VideoInfo> detail(@PathVariable Integer videoId) {
        return videoService.detail(videoId);
    }
}
