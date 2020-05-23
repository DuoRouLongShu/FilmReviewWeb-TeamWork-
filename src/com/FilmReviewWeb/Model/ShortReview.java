package com.FilmReviewWeb.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 短评
 *
 * @author HTwo2O
 * @date 2020/5/13 13:58
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShortReview {
    private Integer reviewId;
    private Integer checkout;
    private Integer pass;
    private float rating;
    private String userName;
    private Integer userId;
    private String filmName;
    private String filmId;
    private String creatDate;
    private String text;
    private Integer likes;


}
