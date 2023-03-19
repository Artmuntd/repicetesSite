package com.example.repicesite.dto;

import com.example.repicesite.model.Ingredient;
import com.example.repicesite.model.Repice;

import java.util.List;

public class RecipeDto {
    private final int id;
    private final  String name;
    private final int timeCooking;
    private final List<Ingredient> ingredients;
    private final List<String> steps;

    public RecipeDto(int id, String name, int timeCooking, List<Ingredient> ingredients, List<String> steps) {
        this.id = id;
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

    public int getTimeCooking() {
        return timeCooking;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public List<String> getSteps() {
        return steps;
    }
    public  static  RecipeDto from(int id, Repice repice){
        return  new RecipeDto(id, repice.getName(), repice.getTimeCooking(), repice.getIngredients(),
                repice.getSteps());
    }
}
