package com.example.repicesite.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Recipe {
    private  String title;

    private  int cookingTime;

    private List<Ingredient> ingredients;

    private List<String> steps;

    public void setTitle(String title) {
        StringUtils.isBlank(title);
    }
}
