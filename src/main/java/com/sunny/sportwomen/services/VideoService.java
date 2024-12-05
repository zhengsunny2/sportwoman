package com.sunny.sportwomen.services;

import com.sunny.sportwomen.entity.VideoInfo;
import com.sunny.sportwomen.pojo.ApiResponse;
import com.sunny.sportwomen.pojo.PageVO;

public interface VideoService {

    ApiResponse<PageVO<VideoInfo>> list(String tag, Integer page, Integer pageSize);
    ApiResponse<VideoInfo> detail(Integer id);
}
