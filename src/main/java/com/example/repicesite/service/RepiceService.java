package com.example.repicesite.service;


import com.example.repicesite.model.Repice;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@Service
public class RepiceService {
    private int idCounter = 0;
    private final Map<Integer, Repice> repiceMap = new HashMap<>();

    public Repice addRepice(Repice recipe) {
        int id = idCounter++;
        recipe.setId(id);
        repiceMap.put(id, recipe);
        return recipe;
    }

    public Repice getRepice(int id) {
        return repiceMap.get(id);
    }
}