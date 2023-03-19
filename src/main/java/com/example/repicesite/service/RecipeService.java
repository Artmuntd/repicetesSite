package com.example.repicesite.service;

import com.example.repicesite.dto.RecipeDto;
import com.example.repicesite.model.Repice;

import java.util.HashMap;
import java.util.Map;

public class RecipeService {
    private  int idCounter = 0;
    private final Map<Integer, Repice> repiceMap = new HashMap<>();

    public RecipeDto addRipece(Repice repice){
        int id = idCounter++;
        repiceMap.put(id, repice);
        return RecipeDto.from(id, repice);
    }

    public  RecipeDto getRecipe(int id){
        Repice repice = repiceMap.get(id);
        if ( repice != null){
            return  RecipeDto.from(id,repice);
        }
        return  null;
    }
}
