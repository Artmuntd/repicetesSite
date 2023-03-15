package com.example.repicesite.service;

import com.example.repicesite.model.Ingredient;
import com.example.repicesite.model.Repice;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class IngredientService {
    private int idCounter = 0;
    private  final Map<Integer, Ingredient> ingredientMap = new HashMap<>();

    public  Ingredient addIngredient (Ingredient ingredient){
        int id = idCounter++;
        ingredientMap.put(id, ingredient);


        return new Ingredient(id, ingredient);
    }
    public  Ingredient getIngredient (int id){
        Ingredient ingredient = ingredientMap.get(id);
        if ( ingredient != null) {
            return new Ingredient(id, ingredient);
        }
        return null;
    }
}
