package com.example.repicesite.controller;

import com.example.repicesite.dto.RecipeDTO;
import com.example.repicesite.model.Recipe;
import com.example.repicesite.service.RecipeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recipe")
public class RecipeController {
private  final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

     @GetMapping()
     public List<RecipeDTO> getAllRecipes(){
        return  recipeService.getAllRecipes();
     }
    @GetMapping("/{id}")
    public RecipeDTO getRecipe(@PathVariable("id") int id){
     return recipeService.getRecipe(id);
    }
    @PostMapping
    public RecipeDTO addRecipe(@RequestBody Recipe recipe){
        return  recipeService.addRecipe(recipe);
    }

    @PutMapping("/{id}")
    public RecipeDTO editRecipe(@PathVariable("id") int id,@RequestBody Recipe recipe){
        return recipeService.updateRecipe(id, recipe);
    }
    @DeleteMapping("/{id}")
    public RecipeDTO deleteRecipe(@PathVariable("id") int id,@RequestBody Recipe recipe){
        return  recipeService.deleteById(id);
    }
    @DeleteMapping()
    public ResponseEntity<Void> deleteAllRecipe(){
        recipeService.deleteAllRecipe();
        return ResponseEntity.ok().build();
    }
}
