package com.example.test.myapplication;

public class CardCalendar {
    private String imgURLCalendar1;
    private String imgURLCalendar2;
    private String etapaCalendar;
    private String ligaCalendar;
    private String buttonCumparaBilet;
    private String dataCalendar;
    private String acasaCalendar;
    private String acasaEchipaCalendar;

    public CardCalendar(String imgURLCalendar1, String imgURLCalendar2, String etapaCalendar, String ligaCalendar, String dataCalendar, String acasaCalendar, String acasaEchipaCalendar, String buttonCumparaBilet) {
        this.imgURLCalendar1 = imgURLCalendar1;
        this.imgURLCalendar2 = imgURLCalendar2;
        this.etapaCalendar = etapaCalendar;
        this.ligaCalendar = ligaCalendar;
        this.buttonCumparaBilet = buttonCumparaBilet;
        this.dataCalendar = dataCalendar;
        this.acasaCalendar = acasaCalendar;
        this.acasaEchipaCalendar = acasaEchipaCalendar;
    }

    public String getImgURLCalendar1() {
        return imgURLCalendar1;
    }

    public void setimgURLCalendar1(String imgURLCalendar1) { this.imgURLCalendar1 = imgURLCalendar1; }

    public String getImgURLCalendar2() {
        return imgURLCalendar2;
    }

    public void setimgURLCalendar2(String imgURLCalendar2) { this.imgURLCalendar2 = imgURLCalendar2; }

    public String getEtapaCalendar() { return etapaCalendar; }

    public void setEtapaCalendar(String etapaCalendar) { this.etapaCalendar = etapaCalendar; }

    public String getLigaCalendar() { return ligaCalendar; }

    public void setLigaCalendar(String ligaCalendar) { this.ligaCalendar = ligaCalendar; }

    public String getbuttonCumparaBilet() { return buttonCumparaBilet; }

    public void setbuttonCumparaBilet(String buttonCumparaBilet) { this.buttonCumparaBilet = buttonCumparaBilet; }

    public String getDataCalendar() { return dataCalendar; }

    public void setDataCalendar(String dataCalendar) { this.dataCalendar = dataCalendar; }

    public String getAcasaCalendar() { return acasaCalendar; }

    public void setAcasaCalendar(String acasaCalendar) { this.acasaCalendar = acasaCalendar; }

    public String getAcasaEchipaCalendar() { return acasaEchipaCalendar; }

    public void setAcasaEchipaCalendar(String acasaEchipaCalendar) { this.acasaEchipaCalendar = acasaEchipaCalendar; }

}
