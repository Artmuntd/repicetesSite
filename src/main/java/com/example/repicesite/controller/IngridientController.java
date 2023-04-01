package com.example.repicesite.controller;


import com.example.repicesite.dto.IngredientDTO;
import com.example.repicesite.model.Ingredient;
import com.example.repicesite.model.Recipe;
import com.example.repicesite.service.IngridientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/ingridient")
@Tag(name = "Ингридиенты", description = "Поиск, удаление, добавление ингридиентов.")
public class IngridientController {
    private  final IngridientService ingridientService;

    public IngridientController(IngridientService ingridientService) {
        this.ingridientService = ingridientService;
    }
    @GetMapping()
    @Operation(
            summary = "Получить все ингридиенты",
            description = "Получение всего списка ингридиентов"
    )
    public List<IngredientDTO> getAllIngridients(){
        return ingridientService.getAllIngridient();
    }
    @GetMapping("{id}")
    @Operation(
            summary = "Получить ингридиент по его номеру id",
            description = "Получение ингридиента по его id"
    )
    public IngredientDTO getIngridient(@PathVariable("id") int id){
        return ingridientService.getIngridient(id);
    }
    @PostMapping
    @Operation(
            summary = "Добавление ингридиента",
            description = "Добавить Ингридиент"
    )
    public IngredientDTO addIngredient(@RequestBody Ingredient ingredient){
        return  ingridientService.addIngridient(ingredient);
    }

    @PutMapping("/{id}")
    @Operation(
            summary = "Поменять ингридиент"
    )
    public IngredientDTO editIngredient(@PathVariable("id") int id,@RequestBody Ingredient ingredient){
        return ingridientService.updateIngridient(id, ingredient);
    }
    @DeleteMapping("/{id}")
    @Operation(
            summary = "Удаление одного ингридиента",
            description = "Удаление ингридиента по id"
    )
    public IngredientDTO deleteIngredient(@PathVariable("id") int id,@RequestBody Recipe recipe){
        return  ingridientService.deleteById(id);
    }
    @DeleteMapping()
    @Operation(
            summary = "Удаление ингридиентов",
            description = "Удаление всех имеющихся ингридиентов "
    )
    public ResponseEntity<Void> deleteAllRecipe(){
        ingridientService.deleteAllRecipe();
        return ResponseEntity.ok().build();
    }
}
