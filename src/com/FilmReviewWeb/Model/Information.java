package com.FilmReviewWeb.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Information implements Serializable {
    private String userName;
    private String gender;
    private String petName ;
    private String birthday;
    private String hobby;
    private String email;
    private String imageResource;
    private String signature;



}
