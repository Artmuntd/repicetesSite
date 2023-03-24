package com.example.repicesite.service;

import com.example.repicesite.dto.RecipeDTO;
import com.example.repicesite.model.Recipe;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RecipeService {
    private int idCounter = 0;

    private Map<Integer, Recipe> recipes = new HashMap<>();

    public RecipeDTO addRecipe(Recipe recipe){
      int id = idCounter++;
      recipes.put(id, recipe);
      return  RecipeDTO.from(id, recipe);
    }

    public RecipeDTO getRecipe(int id) {
        Recipe recipe = recipes.get(id);
        if (recipe != null){
            return  RecipeDTO.from(id, recipe);
        }
        return  null;
    }

    public List<RecipeDTO> getAllRecipes() {
        List<RecipeDTO> result = new ArrayList<>();
       for(Map.Entry<Integer,Recipe> entry: recipes.entrySet()){
           result.add(RecipeDTO.from(entry.getKey(),entry.getValue()));       }
        return result;
    }

    public RecipeDTO updateRecipe(int id, Recipe recipe) {
        Recipe pathRecipe = recipes.get(id);
        if(pathRecipe == null){
            throw new RecipeNotFound();
        }
        recipes.put(id,recipe);
        return  RecipeDTO.from(id, recipe);
    }

    public RecipeDTO deleteById(int id) {
        Recipe deleteRecipe = recipes.remove(id);
        if( deleteRecipe == null){
            throw new RecipeNotFound();
        }
      return  RecipeDTO.from(id, deleteRecipe);
    }
    public  void deleteAllRecipe(){
        recipes = new TreeMap<>();
    }
}
