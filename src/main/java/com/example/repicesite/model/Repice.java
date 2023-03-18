package com.example.repicesite.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
@Data
@AllArgsConstructor

public class Repice {
    private final int id;
    private String name;
    private  int timeCooking;
    private List<Ingredient> ingredients;
    private List<String> steps;



    public Repice(int id, Repice recipe) {
        this.id = id;
       this.name = recipe.name;
       this.timeCooking = recipe.timeCooking;
       this.ingredients = recipe.ingredients;
       this.steps = recipe.steps;
    }

    public Repice(String name, int timeCooking, List<Ingredient> ingredients, List<String> steps) {
        this.id = -1;
        this.name = name;
        this.timeCooking = timeCooking;
        this.ingredients = ingredients;
        this.steps = steps;
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
