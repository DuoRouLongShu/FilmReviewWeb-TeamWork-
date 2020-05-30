package com.FilmReviewWeb.Model;


import lombok.*;

/**
 * 影评
 *
 * @author HTwo2O
 * @date 2020/5/13 13:58
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Review {
    private Integer reviewId;
    private Integer check;
    private Integer pass;
    @NonNull
    private float rating;
    @NonNull
    private String userName;
    private Integer userId;
    @NonNull
    private String filmName;
    private Integer filmId;
    private String creatDate;
    @NonNull
    private String text;
    private Integer likes;
    @NonNull
    private String title;



}
