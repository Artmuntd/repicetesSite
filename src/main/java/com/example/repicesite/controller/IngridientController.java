package com.example.repicesite.controller;


import com.example.repicesite.dto.IngredientDTO;
import com.example.repicesite.dto.RecipeDTO;
import com.example.repicesite.model.Ingredient;
import com.example.repicesite.model.Recipe;
import com.example.repicesite.service.IngridientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ingridient")
public class IngridientController {
    private  final IngridientService ingridientService;

    public IngridientController(IngridientService ingridientService) {
        this.ingridientService = ingridientService;
    }
    @GetMapping()
    public List<IngredientDTO> getAllIngridients(){
        return ingridientService.getAllIngridient();
    }
    @GetMapping("{id}")
    public IngredientDTO getIngridient(@PathVariable("id") int id){
        return ingridientService.getIngridient(id);
    }
    @PostMapping
    public IngredientDTO addIngredient(@RequestBody Ingredient ingredient){
        return  ingridientService.addIngridient(ingredient);
    }

    @PutMapping("/{id}")
    public IngredientDTO editIngredient(@PathVariable("id") int id,@RequestBody Ingredient ingredient){
        return ingridientService.updateIngridient(id, ingredient);
    }
    @DeleteMapping("/{id}")
    public IngredientDTO deleteIngredient(@PathVariable("id") int id,@RequestBody Recipe recipe){
        return  ingridientService.deleteById(id);
    }
    @DeleteMapping()
    public ResponseEntity<Void> deleteAllRecipe(){
        ingridientService.deleteAllRecipe();
        return ResponseEntity.ok().build();
    }
}
