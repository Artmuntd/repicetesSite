package com.example.repicesite.controller;


import com.example.repicesite.dto.RecipeDto;
import com.example.repicesite.service.RecipeService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/recipe")
public class RepiceController {

    private final RecipeService recipeService;

    public RepiceController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }


    @GetMapping("/{id}")
    public RecipeDto getRecipe(@PathVariable("id") int id){
   return  recipeService.getRecipe(id);
}

}
