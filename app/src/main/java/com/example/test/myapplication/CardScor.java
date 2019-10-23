package com.example.test.myapplication;

public class CardScor {
    private Integer imgscor1;
    private Integer imgscor2;
    private String title;
    private String subtitle;
    private String scor1;
    private String scor2;
    private String titlu_echipa1;
    private String titlu_echipa2;


    public CardScor(/*Integer imgscor1, Integer imgscor2,*/ String title, String subtitle, String scor1, String scor2, String titlu_echipa1, String titlu_echipa2) {
        this.imgscor1 = imgscor1;
        this.imgscor2 = imgscor2;
        this.title = title;
        this.subtitle = subtitle;
        this.scor1 = scor1;
        this.scor2 = scor2;
        this.titlu_echipa1 = titlu_echipa1;
        this.titlu_echipa2 = titlu_echipa2;
    }

    public Integer getImgscor1() {
        return imgscor1;
    }

    public void setImgscor1(Integer imgscor1) {
        this.imgscor1 = imgscor1;
    }

    public Integer getImgscor2() { return imgscor2;}

    public void setImgscor2(Integer imgscor2) {
        this.imgscor2 = imgscor2;
    }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getSubtitle() { return subtitle; }

    public void setSubtitle(String subtitle) { this.subtitle = subtitle; }

    public String getScor1() { return scor1; }

    public void setScor1(String scor1) {
        this.scor1 = scor1;
    }

    public String getScor2() { return scor2; }

    public void setScor2(String scor2) {
        this.scor2 = scor2;
    }

    public String getTitlu_echipa1() { return titlu_echipa1; }

    public void setTitlu_echipa1(String titlu_echipa1) {
        this.titlu_echipa1 = titlu_echipa1;
    }

    public String getTitlu_echipa2() { return titlu_echipa2; }

    public void setTitlu_echipa2(String titlu_echipa2) {
        this.titlu_echipa2 = titlu_echipa2;
    }
}