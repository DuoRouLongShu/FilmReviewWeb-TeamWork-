package com.FilmReviewWeb.Model;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * 影评
 * @author HTwo2O
 * @date 2020/5/13 13:58
 */
@RequiredArgsConstructor
public class Review  {
    private int reviewId;
    private int checkout;
    private int pass;
    @NonNull
    private float rating;
    @NonNull
    private String userName;
    private int userId;
    @NonNull
    private String filmName;
    private int filmId;
    private String creatDate;
    @NonNull
    private String text;
    private int likes;
    @NonNull
    private String title;


    public Review() {
    }

    public Review(int reviewId, int checkout, int pass, float rating, String userName, int userId, String filmName, int filmId, String creatDate, String text, int likes,String title) {
        this.reviewId = reviewId;
        this.checkout = checkout;
        this.pass = pass;
        this.rating = rating;
        this.userName = userName;
        this.userId = userId;
        this.filmName = filmName;
        this.filmId = filmId;
        this.creatDate = creatDate;
        this.text = text;
        this.likes = likes;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public int getCheckout() {
        return checkout;
    }

    public void setCheckout(int checkout) {
        this.checkout = checkout;
    }

    public int getPass() {
        return pass;
    }

    public void setPass(int pass) {
        this.pass = pass;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public String getCreatDate() {
        return creatDate;
    }

    public void setCreatDate(String creatDate) {
        this.creatDate = creatDate;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    @Override
    public String toString() {
        return "Review{" +
                "reviewId=" + reviewId +
                ", checkout=" + checkout +
                ", pass=" + pass +
                ", rating=" + rating +
                ", userName='" + userName + '\'' +
                ", userId=" + userId +
                ", filmName='" + filmName + '\'' +
                ", filmId='" + filmId + '\'' +
                ", creatDate='" + creatDate + '\'' +
                ", text='" + text + '\'' +
                ", likes=" + likes +
                ", title='" + title + '\'' +
                '}';
    }
}
