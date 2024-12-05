package com.sunny.sportwomen.services.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sunny.sportwomen.entity.VideoInfo;
import com.sunny.sportwomen.mapper.VideoMapper;
import com.sunny.sportwomen.pojo.ApiResponse;
import com.sunny.sportwomen.pojo.ApiResponseCode;
import com.sunny.sportwomen.pojo.PageVO;
import com.sunny.sportwomen.services.VideoService;
import com.sunny.sportwomen.util.PageUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoMapper videoMapper;

    @Override
    public ApiResponse<PageVO<VideoInfo>> list(String tag, Integer page, Integer pageSize) {
        LambdaQueryWrapper<VideoInfo> queryWrapper = new LambdaQueryWrapper<>(VideoInfo.class);

        if (!StringUtils.isBlank(tag)) {
            queryWrapper.like(VideoInfo::getTags, tag);
        }

        IPage<VideoInfo> result = videoMapper.selectPage(new Page<>(page, pageSize), queryWrapper);

        return ApiResponse.buildSuccess(PageUtil.toPageVO(result));
    }

    @Override
    public ApiResponse<VideoInfo> detail(Integer id) {
        VideoInfo res = videoMapper.selectById(id);

        if (res == null) {
            return ApiResponse.buildFail(ApiResponseCode.InvalidArgument, "视频不存在");
        }

        return ApiResponse.buildSuccess(res);
    }
}
