package com.FilmReviewWeb.Model;

public class Slideshow {

    private int id;
    private String imageSource;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImageSource() {
        return imageSource;
    }

    public void setImageSource(String imageSource) {
        this.imageSource = imageSource;
    }

    public Slideshow(){

    }
    public Slideshow(int id, String imageSource) {
        this.id = id;
        this.imageSource = imageSource;
    }

    @Override
    public String toString() {
        return "Slideshow{" +
                "id=" + id +
                ", imageSource='" + imageSource + '\'' +
                '}';
    }
}
