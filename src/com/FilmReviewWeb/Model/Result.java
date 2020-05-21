package com.FilmReviewWeb.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 返回前端的封装类
 * @author HTwo2O
 * @date 2020/5/13 14:13
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result implements Serializable {

    private String message;
    private Object data;
    private Integer dataCount;
    //需要分页时的页数
    private Integer pageCount;


}
