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
        Ingredient ingredients = new Ingredient(id,ingredient.getTitle(),ingredient.getQuantity(),ingredient.getMeasure());
        ingredientMap.put(id,ingredients);

        return ingredients;
    }
    public  Ingredient getIngredient (int id){
      return  ingredientMap.get(id);
    }

    public boolean  deleteIngredient(int id){
        for (Ingredient ingredient : ingredientMap.values()){
            if(ingredientMap.containsKey(id)){
                ingredientMap.remove(id);
                return  true;
            }
        }
        return false;
    }
}
