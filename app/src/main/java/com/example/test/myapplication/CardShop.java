package com.example.test.myapplication;

public class CardShop {
    private String imgURL;
    private String title;
    private String description;
    private String price;
    private String button;

    public CardShop(String imgURL, String title, String description, String price, String button) {
        this.imgURL = imgURL;
        this.title = title;
        this.description = description;
        this.price = price;
        this.button = button;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getButton() {
        return button;
    }

    public void setButton(String button) {
        this.button = button;
    }


}