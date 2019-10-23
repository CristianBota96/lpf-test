package com.example.test.myapplication;

public class CardEchipa {
    private String imgJucator;
    private String numar;
    private String nume;
    private String tara;

    public CardEchipa(String imgJucator, String numar, String nume, String tara) {
        this.imgJucator = imgJucator;
        this.numar = numar;
        this.nume = nume;
        this.tara = tara;
    }

    public String getImgJucator() {
        return imgJucator;
    }

    public void setImgJucator(String imgJucator) {
        this.imgJucator = imgJucator;
    }

    public String getNumar() { return numar; }

    public void setNumar(String numar) { this.numar = numar; }

    public String getNume() { return nume; }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getTara() { return tara; }

    public void setTara(String tara) {
        this.tara = tara;
    }
}