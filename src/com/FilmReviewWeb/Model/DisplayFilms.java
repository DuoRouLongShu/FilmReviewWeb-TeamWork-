package com.FilmReviewWeb.Model;

import java.io.Serializable;

/**
 * 首页展示电影
 * @author HTwo2O
 * @date 2020/5/12 20:52
 */
public class DisplayFilms implements Serializable {
    //判断标志，1为轮播图，0为非轮播图
    private String filmName;
    private String imageSource;
    private int cid;
    private float rating ;

    public DisplayFilms() {
    }




    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }



    public String getImageSource() {
        return imageSource;
    }

    public void setImageSource(String imageSource) {
        this.imageSource = imageSource;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public DisplayFilms(int rotation, String filmName, String imageSource, int cid, float rating) {
        this.filmName = filmName;
        this.imageSource = imageSource;
        this.cid = cid;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "DisplayFilms{" +
                "filmName='" + filmName + '\'' +
                ", imageSource='" + imageSource + '\'' +
                ", cid=" + cid +
                ", rating=" + rating +
                '}';
    }
}
