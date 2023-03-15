package com.example.repicesite.service;


import com.example.repicesite.model.Repice;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@Service
public class RepiceService {
    private  int idCounter = 0;
    private final Map<Integer, Repice> repiceMap = new HashMap<>();

    public Repice  addRepice( Repice recipe){
        int id = idCounter++;
        repiceMap.put(id, recipe);


        return new Repice(id, recipe);
    }

    public  Repice getRepice (int id){
        Repice repice = repiceMap.get(id);
        if ( repice != null) {
            return new Repice(id, repice);
        }
        return null;
    }



}
