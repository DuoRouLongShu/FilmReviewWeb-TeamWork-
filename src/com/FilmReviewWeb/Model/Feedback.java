package com.FilmReviewWeb.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 用户反馈
 *
 * @author HTwo2O
 * @date 2020/5/12 20:58
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Feedback implements Serializable {
    private Integer feedbackId;
    private Integer userId;
    private String userName;
    private String creatDate;
    private String text;
    private Integer read;


}
