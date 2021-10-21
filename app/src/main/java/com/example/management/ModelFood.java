package com.example.management;

public class ModelFood {

    private  String image;
    private String name,place,price;

    public ModelFood(String image, String name, String place, String price) {
        this.image = image;
        this.name = name;
        this.place = place;
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
