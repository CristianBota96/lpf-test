package com.example.test.myapplication;

public class CardBilete {
    private String pozitia;
    private String locul;
    private String pretbilet;
    private Integer nr_bilete;


    public CardBilete( String locul, String pozitia, String pretbilet, Integer nr_bilete) {
        this.pozitia = pozitia;
        this.locul = locul;
        this.pretbilet = pretbilet;
        this.nr_bilete = nr_bilete;
    }

    public String getPozitia() {
        return pozitia;
    }

    public void setPozitia(String pozitia) {
        this.pozitia = pozitia;
    }

    public String getLocul() { return locul; }

    public void setLocul(String locul) { this.locul = locul; }

    public String getPretbilet() { return pretbilet; }

    public void setPretbilet(String pretbilet) {
        this.pretbilet = pretbilet;
    }

    public Integer getNr_bilete() { return nr_bilete; }

    public void setNr_bilete(Integer nr_bilete) {
        this.nr_bilete = nr_bilete;
    }
}