package com.FilmReviewWeb.Model;

import java.io.Serializable;

/**
 * @author HTwo2O
 * @date 2020/5/13 16:00
 */
public class Film implements Serializable {
    private int filmId;
    private String filmName;
    //评分
    private float rating ;
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

    public Film() {
    }

    public Film(int filmId, String filmName, float rating, String director, String writer, String performer, String genre, String area, String language, String duration, String synopsis) {
        this.filmId = filmId;
        this.filmName = filmName;
        this.rating = rating;
        this.director = director;
        this.writer = writer;
        this.performer = performer;
        this.genre = genre;
        this.area = area;
        this.language = language;
        this.duration = duration;
        this.synopsis = synopsis;
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

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getPerformer() {
        return performer;
    }

    public void setPerformer(String performer) {
        this.performer = performer;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    @Override
    public String toString() {
        return "Film{" +
                "filmId=" + filmId +
                ", filmName='" + filmName + '\'' +
                ", rating=" + rating +
                ", director='" + director + '\'' +
                ", writer='" + writer + '\'' +
                ", performer='" + performer + '\'' +
                ", genre='" + genre + '\'' +
                ", area='" + area + '\'' +
                ", language='" + language + '\'' +
                ", duration='" + duration + '\'' +
                ", synopsis='" + synopsis + '\'' +
                '}';
    }
}
