package com.campstore.cityguide.model;

public class Category {
    private int img;
    private String name;

    public Category(int img, String name) {
        this.img = img;
        this.name = name;
    }

    public int getImg() {
        return img;
    }

    public String getName() {
        return name;
    }
}
