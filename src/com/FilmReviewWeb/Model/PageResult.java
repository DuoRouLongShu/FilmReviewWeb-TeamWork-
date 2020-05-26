package com.FilmReviewWeb.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 后台分页式返回前端的封装类
 *
 * @author HTwo2O
 * @date 2020/5/26 11:01
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PageResult {
    private String message;
    private Object data;

    //当前页数据数
    private Integer currentDataCount;

    //数据总数
    private Integer totalDataCount;

    //当前页数
    private Integer currentPageNumber;

    //总页数
    private Integer totalPageCount;
}
