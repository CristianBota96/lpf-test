package com.example.test.myapplication;

public class CardClasament {
    private String loc;
    private String img_club;
    private String nume_club;
    private String mj_echipa;
    private String pct_echipa;
    private String gm_echipa;
    private String gp_echipa;

    public CardClasament(String loc, String img_club, String nume_club, String mj_echipa, String pct_echipa, String gm_echipa, String gp_echipa) {
        this.loc = loc;
        this.img_club = img_club;
        this.nume_club = nume_club;
        this.mj_echipa = mj_echipa;
        this.pct_echipa = pct_echipa;
        this.gm_echipa = gm_echipa;
        this.gp_echipa = gp_echipa;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public String getImg_club() { return img_club; }

    public void setImg_club(String img_club) { this.img_club = img_club; }

    public String getNume_club() { return nume_club; }

    public void setNume_club(String nume_club) { this.nume_club = nume_club; }

    public String getMj_echipa() { return mj_echipa; }

    public void setMj_echipa(String mj_echipa) {
        this.mj_echipa = mj_echipa;
    }
    public String getPct_echipa() { return pct_echipa; }

    public void setPct_echipa(String pct_echipa) { this.pct_echipa = pct_echipa; }

    public String getGm_echipa() { return gm_echipa; }

    public void setGm_echipa(String gm_echipa) { this.gm_echipa = gm_echipa; }

    public String getGp_echipa() { return gp_echipa; }

    public void setGp_echipa(String gp_echipa) { this.gp_echipa = gp_echipa; }




}