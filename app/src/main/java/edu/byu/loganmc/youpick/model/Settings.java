package edu.byu.loganmc.youpick.model;

/**
 * Created by thelo on 10/1/2017.
 */

public class Settings {
    private static Settings singleton = null;

    private boolean animations = true;
    private boolean sounds = true;
    private int maxPrice = 4;
    private int minPrice = 1;
    private int radiusInMiles = 10;

    private Settings(){

    }

    public static Settings getInstance(){
        if (singleton == null){
            singleton = new Settings();
        }
        return singleton;
    }


    public void setInstance(Settings singleton) {
        this.singleton = singleton;
    }

    public boolean isAnimations() {
        return animations;
    }

    public void setAnimations(boolean animations) {
        this.animations = animations;
    }

    public boolean isSounds() {
        return sounds;
    }

    public void setSounds(boolean sounds) {
        this.sounds = sounds;
    }

    public int getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(int maxPrice) {
        this.maxPrice = maxPrice;
    }

    public int getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(int minPrice) {
        this.minPrice = minPrice;
    }

    public int getRadiusInMiles() {
        return radiusInMiles;
    }

    public void setRadiusInMiles(int radiusInMiles) {
        this.radiusInMiles = radiusInMiles;
    }
}
