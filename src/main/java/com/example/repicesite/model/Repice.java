package com.example.repicesite.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;


public class Repice {
    private final int id;
    private String name;
    private  int timeCooking;
    private List<Ingredient> ingredients;
    private List<String> steps;


    public Repice(int id, String name, int timeCooking, List<Ingredient> ingredients, List<String> steps) {
        this.id = id;
        this.name = name;
        this.timeCooking = timeCooking;
        this.ingredients = ingredients;
        this.steps = steps;
    }

    public Repice(int id, Repice recipes) {
        this.id = id;
        Repice repices = recipes;
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTimeCooking() {
        return timeCooking;
    }

    public void setTimeCooking(int timeCooking) {
        this.timeCooking = timeCooking;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public List<String> getSteps() {
        return steps;
    }

    public void setSteps(List<String> steps) {
        this.steps = steps;
    }


}