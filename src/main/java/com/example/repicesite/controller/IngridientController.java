package com.example.repicesite.controller;

import com.example.repicesite.model.Ingredient;
import com.example.repicesite.service.IngredientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ingridient")
public class IngridientController {
    private final IngredientService ingredientService;


    public IngridientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }
    @GetMapping("/{id}")
    public Ingredient getIngredient(@PathVariable("id") int id){
        return ingredientService.getIngredient(id);
    }
    @PostMapping()
    public  Ingredient addIngridient(@RequestBody Ingredient ingredient){
        return  ingredientService.addIngredient(ingredient);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteIngredient(@PathVariable int id){
        if(ingredientService.deleteIngredient(id)){
            return ResponseEntity.ok().build();
        }
        return  ResponseEntity.notFound().build();
    }
}
