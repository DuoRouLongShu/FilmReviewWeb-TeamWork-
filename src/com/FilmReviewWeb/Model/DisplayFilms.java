package com.FilmReviewWeb.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 首页展示电影
 * @author HTwo2O
 * @date 2020/5/12 20:52
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DisplayFilms implements Serializable {
    //判断标志，1为轮播图，0为非轮播图
    private Integer rotation;
    private String filmName;
    private String content;
    private String imageSource;

}
