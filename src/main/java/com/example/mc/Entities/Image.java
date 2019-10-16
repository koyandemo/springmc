package com.example.mc.Entities;


public class Image {

    private String name;
    private String imagePath;


    public Image() {
    }

    public Image(String name, String imagePath) {
        this.name = name;
        this.imagePath = imagePath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImagepath() {
        return imagePath;
    }

    public void setImagepath(String imagepath) {
        this.imagePath = imagepath;
    }
}
