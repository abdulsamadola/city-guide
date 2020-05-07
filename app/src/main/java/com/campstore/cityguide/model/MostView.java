package com.campstore.cityguide.model;

public class MostView {

    private int img, desc;
    private String title;

    public MostView(int img, int desc, String title) {
        this.img = img;
        this.desc = desc;
        this.title = title;
    }

    public int getImg() {
        return img;
    }

    public int getDesc() {
        return desc;
    }

    public String getTitle() {
        return title;
    }
}
