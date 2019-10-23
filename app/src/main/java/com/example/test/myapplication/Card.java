package com.example.test.myapplication;

public class Card {
    private String imgURL;
    private String title;
    private String description;

    public Card(String imgURL, String title, String description) {
        this.imgURL = imgURL;
        this.title = title;
        this.description = description;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public String getTitle() { return title; }

    public String getDescription() { return description; }

    public void setTitle(String title) { this.title = title; }

    public void setDescription(String description) {
        this.description = description;
    }
}