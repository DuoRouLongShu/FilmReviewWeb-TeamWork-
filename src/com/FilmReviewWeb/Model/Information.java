package com.FilmReviewWeb.Model;

import java.io.Serializable;

public class Information implements Serializable {
    private String userName;
    private String gender;
    private String petName ;
    private String birthday;
    private String hobby;
    private String email;
    private String imageResource;
    private String signature;


    public String getImageResource() {
        return imageResource;
    }

    public void setImageResource(String imageResource) {
        this.imageResource = imageResource;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Information(String userName, String creatDate, String gender,
                       String petName, String birthday, String hobby, String email,
                       String imageResource, String signature) {
        this.userName = userName;
        this.gender = gender;
        this.petName = petName;
        this.birthday = birthday;
        this.hobby = hobby;
        this.email = email;
        this.imageResource = imageResource;
        this.signature = signature;
    }

    public Information(){

    }

    @Override
    public String toString() {
        return "Information{" +
                "userName='" + userName + '\'' +
                ", gender='" + gender + '\'' +
                ", petName='" + petName + '\'' +
                ", birthday='" + birthday + '\'' +
                ", hobby='" + hobby + '\'' +
                ", email='" + email + '\'' +
                ", imageResource='" + imageResource + '\'' +
                ", signature='" + signature + '\'' +
                '}';
    }
}
