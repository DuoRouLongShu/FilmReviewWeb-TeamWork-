package com.FilmReviewWeb.Model;

import java.io.Serializable;

/**
 * 首页展示电影
 * @author HTwo2O
 * @date 2020/5/12 20:52
 */
public class DisplayFilms implements Serializable {
    private int displayId;
    private int filmId;
    private String filmName;
    private String content;
    private String imageSource;

    public int getDisplayId() {
        return displayId;
    }

    public void setDisplayId(int displayId) {
        this.displayId = displayId;
    }

    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
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

    @Override
    public String toString() {
        return "displayFilms{" +
                "displayId=" + displayId +
                ", filmId=" + filmId +
                ", filmName='" + filmName + '\'' +
                ", content='" + content + '\'' +
                ", imageSource='" + imageSource + '\'' +
                '}';
    }
}
