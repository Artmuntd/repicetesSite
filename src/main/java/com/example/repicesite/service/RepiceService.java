package com.example.repicesite.service;


import com.example.repicesite.model.Repice;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

@Service
public class RepiceService {
    private int idCounter = 0;
    private Map<Integer, Repice> repiceMap = new HashMap<>();

    public Repice addRecipe(Repice recipe) {
        int id = idCounter++;
        recipe.setId(id);
        repiceMap.put(id, recipe);
        return recipe;
    }

    public Repice getRecipe(int id) {
        return repiceMap.get(id);
    }

    public Repice getAllRecipe(){

    }
    public boolean  deleteRecipe(int id){
        for (Repice recipe : repiceMap.values() ) {
            if(repiceMap.containsKey(id)){
                repiceMap.remove(id);

                return true;
            }
        }
        return false;
    }
    public void  deleteAllRecipe(){
        repiceMap = new TreeMap<>();
    }
}