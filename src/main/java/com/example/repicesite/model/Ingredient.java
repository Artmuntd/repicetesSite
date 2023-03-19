package com.example.repicesite.model;

import lombok.AllArgsConstructor;
import lombok.Data;



public class Ingredient {

    private  String title;
    private  int quantity;
    private String measure;


    public Ingredient(String title, int quantity, String measure) {
        this.title = title;
        this.quantity = quantity;
        this.measure = measure;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }
}
