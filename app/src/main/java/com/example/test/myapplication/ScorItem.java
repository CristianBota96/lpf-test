package com.example.test.myapplication;

public class ScorItem {
    private String scor1;
    private String scor2;
    private String textechipa1;
    private String textechipa2;
    private int imgechipa1;
    private int imgechipa2;


    public ScorItem(String scor1, String scor2, String textechipa1, String textechipa2, int imgechipa1, int imgechipa2){
        this.scor1 = scor1;
        this.scor2 = scor2;
        this.textechipa1= textechipa1;
        this.textechipa2= textechipa2;
        this.imgechipa1 = imgechipa1;
        this.imgechipa2 = imgechipa2;
    }
    public String getScor1(){return scor1;}

    public String getScor2() {return scor2;}

    public String getTextechipa1() { return textechipa1; }

    public String getTextechipa2() { return textechipa2; }

    public int getImgechipa1() { return imgechipa1; }

    public int getImgechipa2() { return imgechipa2; }
}
