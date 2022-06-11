package com.example.licheapp.HelperClasses.HomeAdapter;

public class FeaturedHelperClass {

    int image;
    String title, desc;


    public FeaturedHelperClass(int image, String title, String description) {
        this.image = image;
        this.title = title;
        this.desc = description;
    }


    public int getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return desc;
    }
}
