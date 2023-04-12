package com.example.medic;

public class ViewPagerItem {
    String mainText, text;

    public ViewPagerItem(String mainText, String text, int imageId) {
        this.mainText = mainText;
        this.text = text;
        this.imageId = imageId;
    }

    int imageId;
}
