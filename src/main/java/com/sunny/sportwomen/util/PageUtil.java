package com.sunny.sportwomen.util;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.sunny.sportwomen.pojo.PageVO;

public class PageUtil {

    public static <T> PageVO<T> toPageVO(IPage<T> pageResult) {
        PageVO<T> vo = new PageVO<T>();

        vo.setCurrentPage((int) pageResult.getCurrent());
        vo.setPageSize((int) pageResult.getSize());
        vo.setTotalCount((int) pageResult.getTotal());
        vo.setPageCount((int) pageResult.getPages());
        vo.setData(pageResult.getRecords());

        return vo;
    }
}
