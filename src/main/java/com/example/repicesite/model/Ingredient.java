package com.example.repicesite.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class Ingredient {

    private final int id;
    private  String title;
    private  int quantity;
    private String measure;


    public Ingredient(int id, Ingredient ingredient) {
        this.id = id;
        Ingredient ingredients = ingredient;

    }
}