package com.example.repicesite.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Repice {
    private int id;
    private String name;
    private int timeCooking;
    private List<Ingredient> ingredients;
    private List<String> steps;
}




