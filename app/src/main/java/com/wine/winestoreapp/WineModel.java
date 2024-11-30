package com.wine.winestoreapp;

public class WineModel {

    private String name;
    private int imageResourceId;
    private String price;

    public WineModel(String name, int imageResourceId, String price) {
        this.name = name;
        this.imageResourceId = imageResourceId;
        this.price = price;
    }

    public String getName() { return name; }
    public int getImageResourceId() {
        return imageResourceId;
    }
    public String getPrice() { return price;}
}