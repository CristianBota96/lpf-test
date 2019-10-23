package com.example.test.myapplication;

public class CardDetaliiStatistici {
    private String imgbackground;
    private String scor1;
    private String scor2;
    private String titlu_mijloc;


    public CardDetaliiStatistici(/*String imgbackground,*/ String scor1, String scor2, String titlu_mijloc) {
        this.imgbackground = imgbackground;
        this.scor1 = scor1;
        this.scor2 = scor2;
        this.titlu_mijloc = titlu_mijloc;
    }

    public String getImgbackground() {
        return imgbackground;
    }

    public void setImgbackground(String imgbackground) {
        this.imgbackground = imgbackground;
    }

    public String getScor1() { return scor1; }

    public void setScor1(String scor1) {
        this.scor1 = scor1;
    }

    public String getScor2() { return scor2; }

    public void setScor2(String scor2) {
        this.scor2 = scor2;
    }

    public String getTitlu_mijloc() { return titlu_mijloc; }

    public void setTitlu_mijloc(String titlu_mijloc) {
        this.titlu_mijloc = titlu_mijloc;
    }
}