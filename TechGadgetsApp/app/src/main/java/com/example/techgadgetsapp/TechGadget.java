package com.example.techgadgetsapp;

public class TechGadget {

    private String title;
    private int image;
    private String url;

    public TechGadget(String title, int image, String url) {
        this.title = title;
        this.image = image;
        this.url = url;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImage() {
        return this.image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return this.title;
    }
}
