package com.example.carrental;

public class Car {

    private String name;
    private int img;
    private int dailyPrice;
    private String description;

    public Car(String name, int img, int dailyPrice, String description) {
        this.name = name;
        this.img = img;
        this.dailyPrice = dailyPrice;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public int getDailyPrice() {
        return dailyPrice;
    }

    public void setDailyPrice(int dailyPrice) {
        this.dailyPrice = dailyPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
