package com.example.medic.controlers;

public class ViewPagerItem {
    public String mainText;
    public String text;

    public ViewPagerItem(String mainText, String text, int imageId) {
        this.mainText = mainText;
        this.text = text;
        this.imageId = imageId;
    }

    public int imageId;
}
