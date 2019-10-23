package com.example.test.myapplication;

public class CardJucator {
    private String imgjucator;
    private String imgechipa;
    private String nume_jucator;
    private String title;
    private String button;


    public CardJucator(String imgjucator, String imgechipa, String nume_jucator, String title, String button) {
        this.imgjucator = imgjucator;
        this.imgechipa = imgechipa;
        this.title = title;
        this.nume_jucator = nume_jucator;
        this.button= button;

    }

    public String getImgjucator() { return imgjucator; }

    public void setImgjucator(String imgjucator) { this.imgjucator = imgjucator;    }

    public String getImgechipa() { return imgechipa; }

    public void setImgechipa(String imgechipa) { this.imgechipa = imgechipa; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getNume_jucator() { return nume_jucator; }

    public void setNume_jucator(String nume_jucator) { this.nume_jucator = nume_jucator; }

    public String getButton() { return button; }

    public void setButton(String button) { this.button = button; }

}