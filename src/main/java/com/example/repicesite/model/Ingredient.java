package com.example.repicesite.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class Ingredient {
    private  String title;
    private  int quantity;
    private String measure;


}
