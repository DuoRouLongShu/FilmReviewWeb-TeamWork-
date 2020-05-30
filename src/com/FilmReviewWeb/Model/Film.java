package com.FilmReviewWeb.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author HTwo2O
 * @date 2020/5/13 16:00
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Film implements Serializable {
    private Integer filmId;
    private String filmName;
    //评分
    private Float rating ;
    //导演
    private String director;
    private String writer;
    private String performer;
    //题材
    private String genre;
    private String area;
    private String language;
    //片长
    private String duration;
    //概要
    private String synopsis;
    //发布日期
    private String releaseDate;
    //海报图片地址
    private String imageSource;

}
