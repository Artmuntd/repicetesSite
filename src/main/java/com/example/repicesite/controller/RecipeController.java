package com.example.repicesite.controller;

import com.example.repicesite.dto.RecipeDTO;
import com.example.repicesite.model.Recipe;
import com.example.repicesite.service.RecipeService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/recipe")
public class RecipeController {
private  final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }


    @GetMapping("/{id}")
    public RecipeDTO getRecipe(@PathVariable("id") int id){
     return recipeService.getRecipe(id);
    }
    @PostMapping
    public RecipeDTO addRcipe(@RequestBody Recipe recipe){
        return  recipeService.addRecipe(recipe);
    }
}
