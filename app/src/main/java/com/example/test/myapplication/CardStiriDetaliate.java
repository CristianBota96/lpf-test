package com.example.test.myapplication;

public class CardStiriDetaliate {
    private String stiriImage;
    private String titlu_stiri;
    private String subtitlu_stiri;
    private String data_stiri;
    private String text_stiri;

    public CardStiriDetaliate( String stiriImage, String titlu_stiri, String subtitlu_stiri, String data_stiri, String text_stiri) {
        this.titlu_stiri = titlu_stiri;
        this.subtitlu_stiri = subtitlu_stiri;
        this.data_stiri = data_stiri;
        this.text_stiri = text_stiri;
        this.stiriImage = stiriImage;

    }


    public String getStiriImage() { return stiriImage; }

    public void setStiriImage(String stiriImage) { this.stiriImage = stiriImage; }

    public String getTitlu_stiri() { return titlu_stiri; }

    public void setTitlu_stiri(String titlu_stiri) { this.titlu_stiri = titlu_stiri; }

    public String getSubtitlu_stiri() { return subtitlu_stiri; }

    public void setSubtitlu_stiri(String subtitlu_stiri) { this.subtitlu_stiri = subtitlu_stiri; }

    public String getData_stiri() { return data_stiri; }

    public void setData_stiri(String data_stiri) {
        this.data_stiri = data_stiri;
    }

    public String getText_stiri() { return text_stiri; }

    public void setText_stiri(String text_stiri) {
        this.text_stiri = text_stiri;
    }

}