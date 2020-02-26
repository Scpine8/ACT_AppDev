package com.example.bookfinder;

public class Book {

    private String name;
    private int img;
    private String desc;
    private String link;

    public Book(String name, int img, String desc, String link) {
        this.name = name;
        this.img = img;
        this.desc = desc;
        this.link = link;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
