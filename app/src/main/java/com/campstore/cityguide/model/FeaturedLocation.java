package com.campstore.cityguide.model;

public class FeaturedLocation {

    private int image, desc;
    private String title;

    public FeaturedLocation(int image, String title, int desc) {
        this.image = image;
        this.title = title;
        this.desc = desc;
    }

    public int getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public int getDesc() {
        return desc;
    }
}
