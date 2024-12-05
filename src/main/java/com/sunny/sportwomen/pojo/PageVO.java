package com.sunny.sportwomen.pojo;

import lombok.Data;

import java.util.List;

@Data
public class PageVO<T> {

    protected Integer pageCount;

    private Integer currentPage;

    private Integer pageSize;

    private Integer totalCount;

    private List<T> data;
}
