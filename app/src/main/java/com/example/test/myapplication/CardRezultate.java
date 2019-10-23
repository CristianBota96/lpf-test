package com.example.test.myapplication;


public class CardRezultate {
    private String imgURLRezultate1;
    private String imgURLRezultate2;
    private String etapaRezultate;
    private String ligaRezultate;
    private String buttonStatistici;
    private String dataRezultate;
    private String acasaRezultate;
    private String acasaEchipaRezultate;
    private String scor1;
    private String scor2;
    private String card_rezultate;

    public CardRezultate(String imgURLRezultate1, String imgURLRezultate2, String etapaRezultate, String ligaRezultate, String dataRezultate, String acasaRezultate, String acasaEchipaRezultate, String scor1, String scor2, String buttonStatistici, String card_rezultate) {
        this.imgURLRezultate1 = imgURLRezultate1;
        this.imgURLRezultate2 = imgURLRezultate2;
        this.etapaRezultate = etapaRezultate;
        this.ligaRezultate = ligaRezultate;
        this.buttonStatistici = buttonStatistici;
        this.dataRezultate = dataRezultate;
        this.acasaRezultate = acasaRezultate;
        this.acasaEchipaRezultate = acasaEchipaRezultate;
        this.scor1 = scor1;
        this.scor2 = scor2;
        this.card_rezultate= card_rezultate;
    }

    public String getImgURLRezultate1() {
        return imgURLRezultate1;
    }

    public void setImgURLRezultate1(String imgURLRezultate1) { this.imgURLRezultate1 = imgURLRezultate1; }

    public String getImgURLRezultate2() {
        return imgURLRezultate2;
    }

    public void setImgURLRezultate2(String imgURLRezultate2) { this.imgURLRezultate2 = imgURLRezultate2; }

    public String getEtapaRezultate() { return etapaRezultate; }

    public void setEtapaRezultate(String etapaRezultate) { this.etapaRezultate = etapaRezultate; }

    public String getLigaRezultate() { return ligaRezultate; }

    public void setLigaRezultate(String ligaRezultate) { this.ligaRezultate = ligaRezultate; }

    public String getButtonStatistici() { return buttonStatistici; }

    public void setButtonStatistici(String buttonStatistici) { this.buttonStatistici = buttonStatistici; }

    public String getDataRezultate() { return dataRezultate; }

    public void setDataRezultate(String dataRezultate) { this.dataRezultate = dataRezultate; }

    public String getAcasaRezultate() { return acasaRezultate; }

    public void setAcasaRezultate(String acasaRezultate) { this.acasaRezultate = acasaRezultate; }

    public String getAcasaEchipaRezultate() { return acasaEchipaRezultate; }

    public void setAcasaEchipaRezultate(String acasaEchipaRezultate) { this.acasaEchipaRezultate = acasaEchipaRezultate; }

    public String getScor1() { return scor1; }

    public void setScor1(String scor1) { this.scor1 = scor1; }

    public String getScor2() { return scor2; }

    public void setScor2(String scor2) { this.scor2 = scor2; }

    public String getCard_rezultate() { return card_rezultate; }

    public void setCard_rezultate(String card_rezultate) { this.card_rezultate = card_rezultate; }

}