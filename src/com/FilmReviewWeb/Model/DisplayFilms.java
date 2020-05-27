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
<<<<<<< HEAD
    private Integer rotation;
=======
>>>>>>> 6c24ce9592384285b9088bd1b4dc05e07c6fb256
    private String filmName;
    private String imageSource;
    private int cid;
    private float rating ;

<<<<<<< HEAD
=======
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
>>>>>>> 6c24ce9592384285b9088bd1b4dc05e07c6fb256
}
