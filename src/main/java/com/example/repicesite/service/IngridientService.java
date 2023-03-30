package com.example.repicesite.service;

import com.example.repicesite.dto.IngredientDTO;
import com.example.repicesite.model.Ingredient;
import com.example.repicesite.model.Recipe;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;

@Service
public class IngridientService {

 final  private  FileServiceIngredient fileServiceIngredient;
    private  int idCounter = 0;

    private Map<Integer, Ingredient> ingredients = new HashMap<>();

    @PostConstruct
    public void init(){
        readFromFile();
    }
    public IngridientService(FileServiceIngredient fileServiceIngredient) {
        this.fileServiceIngredient = fileServiceIngredient;
    }


    public IngredientDTO addIngridient(Ingredient ingredient){
        int id = idCounter++;
        ingredients.put(id, ingredient);
        saveToFile();
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
        saveToFile();
        return  IngredientDTO.from(id, ingredient);
    }
    public IngredientDTO deleteById(int id) {
       Ingredient deleteIngredient = ingredients.remove(id);
        if( deleteIngredient == null){
            throw new RecipeNotFound();
        }
        saveToFile();
        return  IngredientDTO.from(id, deleteIngredient);
    }
    public  void deleteAllRecipe(){
        ingredients = new TreeMap<>();
    }

    private  void  saveToFile(){
        try {
            String json =  new ObjectMapper().writeValueAsString(ingredients);
            fileServiceIngredient.saveToFile(json);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }

    private  void readFromFile(){
        String json = fileServiceIngredient.readFromFile();
        try {
            ingredients = new ObjectMapper().readValue(json, new TypeReference<Map<Integer, Ingredient>>() {
            });
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }




}
