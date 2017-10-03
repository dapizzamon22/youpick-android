package edu.byu.loganmc.youpick.model;

import java.net.URL;

/**
 * Created by thelo on 9/11/2017.
 */

public class Restaurant {
    public Restaurant(String id, String name, URL image, int priceLevel, double rating) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.priceLevel = priceLevel;
        this.rating = rating;
    }

    private String id;
    private String name;
    private URL image;
    private int priceLevel;
    private double rating;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public URL getImage() {
        return image;
    }

    public void setImage(URL image) {
        this.image = image;
    }

    public int getPriceLevel() {
        return priceLevel;
    }

    public void setPriceLevel(int priceLevel) {
        this.priceLevel = priceLevel;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
