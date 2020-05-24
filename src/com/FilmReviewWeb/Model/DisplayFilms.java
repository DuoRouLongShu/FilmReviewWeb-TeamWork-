package com.FilmReviewWeb.Model;

import java.io.Serializable;

/**
 * 首页展示电影
 * @author HTwo2O
 * @date 2020/5/12 20:52
 */
public class DisplayFilms implements Serializable {
    //判断标志，1为轮播图，0为非轮播图
    private int rotation;
    private String filmName;
    private String content;
    private String imageSource;
    private int cid;

    public DisplayFilms() {
    }



    public int getRotation() {
        return rotation;
    }

    public void setRotation(int rotation) {
        this.rotation = rotation;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public DisplayFilms(int rotation, String filmName, String content, String imageSource, int cid) {
        this.rotation = rotation;
        this.filmName = filmName;
        this.content = content;
        this.imageSource = imageSource;
        this.cid = cid;
    }

    @Override
    public String toString() {
        return "DisplayFilms{" +
                "rotation=" + rotation +
                ", filmName='" + filmName + '\'' +
                ", content='" + content + '\'' +
                ", imageSource='" + imageSource + '\'' +
                ", cid=" + cid +
                '}';
    }
}
