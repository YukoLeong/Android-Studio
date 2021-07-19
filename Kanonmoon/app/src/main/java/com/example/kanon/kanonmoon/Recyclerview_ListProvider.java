package com.example.kanon.kanonmoon;

/**
 * Created by kanon on 2/16/2016.
 */
public class Recyclerview_ListProvider {
    private int image_id;
    private String name, capital;

    public Recyclerview_ListProvider(int image_id, String name, String capital) {
        this.setImage_id(image_id);
        this.setName(name);
        this.setCapital(capital);
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public int getImage_id() {
        return image_id;
    }

    public void setImage_id(int image_id) {
        this.image_id = image_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
