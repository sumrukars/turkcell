package com.example.asus.turkcell;

/**
 * Created by Irem Dogan on 20.09.2017.
 */

public class ImageUpload {


    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public String name;
    public String url;

    public ImageUpload(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public ImageUpload(){ }
}