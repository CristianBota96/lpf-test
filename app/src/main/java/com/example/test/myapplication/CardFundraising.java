package com.example.test.myapplication;

public class CardFundraising {
    private String imgURLFundraising;
    private String titleFunraising;
    private String descriptionFundraising;
    private String buttonFundraising;

    public CardFundraising(String imgURLFundraising, String titleFunraising, String descriptionFundraising, String buttonFundraising) {
        this.imgURLFundraising = imgURLFundraising;
        this.titleFunraising = titleFunraising;
        this.descriptionFundraising = descriptionFundraising;
        this.buttonFundraising = buttonFundraising;
    }

    public String getImgURLFundraising() {
        return imgURLFundraising;
    }

    public void setImgURLFundraising(String imgURLFundraising) {
        this.imgURLFundraising = imgURLFundraising;
    }

    public String getTitleFunraising() { return titleFunraising; }

    public void setTitleFunraising(String titleFunraising) { this.titleFunraising = titleFunraising; }

    public String getDescriptionFundraising() { return descriptionFundraising; }

    public void setDescriptionFundraising(String descriptionFundraising) { this.descriptionFundraising = descriptionFundraising; }

    public String getButtonFundraising() { return buttonFundraising; }

    public void setButtonFundraising(String buttonFundraising) {
        this.buttonFundraising = buttonFundraising;
    }



}