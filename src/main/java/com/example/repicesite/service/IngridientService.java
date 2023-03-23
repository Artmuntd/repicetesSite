package com.example.repicesite.service;

import com.example.repicesite.dto.IngredientDTO;
import com.example.repicesite.dto.RecipeDTO;
import com.example.repicesite.model.Ingredient;
import com.example.repicesite.model.Recipe;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class IngridientService {
    private  int idCounter = 0;

    private Map<Integer, Ingredient> ingredients = new HashMap<>();

    public IngredientDTO addIngridient(Ingredient ingredient){
        int id = idCounter++;
        ingredients.put(id, ingredient);
        return IngredientDTO.from(id, ingredient);
    }

    public IngredientDTO getIngridient(int id) {
        Ingredient ingredient = ingredients.get(id);
        if (ingredient != null){
            return  IngredientDTO.from(id, ingredient);
        }
        return  null;
    }

    public List<IngredientDTO> getAllIngridient() {
        List<IngredientDTO> result = new ArrayList<>();
        for(Map.Entry<Integer,Ingredient> entry: ingredients.entrySet()){
            result.add(IngredientDTO.from(entry.getKey(),entry.getValue()));       }
        return result;
    }
    public IngredientDTO updateIngridient(int id, Ingredient ingredient) {
        Ingredient pathIngridient = ingredients.get(id);
        if(pathIngridient == null){
           return  null;
        }
        ingredients.put(id,ingredient);
        return  IngredientDTO.from(id, ingredient);
    }
    public IngredientDTO deleteById(int id) {
       Ingredient deleteIngredient = ingredients.remove(id);
        if( deleteIngredient == null){
            throw new RecipeNotFound();
        }
        return  IngredientDTO.from(id, deleteIngredient);
    }
    public  void deleteAllRecipe(){
        ingredients = new TreeMap<>();
    }


}
