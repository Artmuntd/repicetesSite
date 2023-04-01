package com.example.repicesite.controller;

import com.example.repicesite.dto.RecipeDTO;
import com.example.repicesite.model.Ingredient;
import com.example.repicesite.model.Recipe;
import com.example.repicesite.service.RecipeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@RequestMapping("/recipe")
@Tag(name = "Рецепты", description = "Поиск, удаление, добавление рецептов.")
public class RecipeController {
private  final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

     @GetMapping()
     @Operation(
             summary = "Получить все рецепты",
             description = "Получение всего списка рецептов"
     )
     @ApiResponses(value = {
             @ApiResponse(
                     responseCode = "200",
                     description = "Получен список рецептов",
                     content = {
                             @Content(
                                     mediaType = "application/json",
                                     array = @ArraySchema(schema = @Schema(implementation = Recipe.class))
                             )

             }
             )
     }
     )

     public List<RecipeDTO> getAllRecipes(){
        return  recipeService.getAllRecipes();
     }
    @GetMapping("/{id}")
    @Operation(
            summary = "Получить рецепт по его номеру id",
            description = "Получение рецепта по его id"
    )
    public RecipeDTO getRecipe(@PathVariable("id") int id){
     return recipeService.getRecipe(id);
    }
    @PostMapping
    @Operation(
            summary = "Добавление рецепта",
            description = "Добавить рецепт"
    )
    public RecipeDTO addRecipe(@RequestBody Recipe recipe){
        return  recipeService.addRecipe(recipe);
    }

    @PutMapping("/{id}")
    @Operation(
            summary = "Внести изменение в рецепт"
    )
    public RecipeDTO editRecipe(@PathVariable("id") int id,@RequestBody Recipe recipe){
        return recipeService.updateRecipe(id, recipe);
    }
    @DeleteMapping("/{id}")
    @Operation(
            summary = "Удаление одного рецепта",
            description = "Удаление рецепта по id"
    )
    public RecipeDTO deleteRecipe(@PathVariable("id") int id,@RequestBody Recipe recipe){
        return  recipeService.deleteById(id);
    }
    @DeleteMapping()
    @Operation(
            summary = "Удалить рецептов",
            description = "Удаление всех имеющихся рецептов "
    )
    public ResponseEntity<Void> deleteAllRecipe(){
        recipeService.deleteAllRecipe();
        return ResponseEntity.ok().build();
    }

    @GetMapping("/downloadRecipes")
    public String downloadRecipes() {
        List<RecipeDTO> recipes = recipeService.getAllRecipes();

        StringBuilder sb = new StringBuilder();

        for (RecipeDTO recipe : recipes) {
            sb.append(recipe.getTitle()).append("\n\n");
            sb.append("Время приготовления: ").append(recipe.getCookingTime()).append("\n\n");
            sb.append("Ингредиенты:\n");

            for (Ingredient ingredient : recipe.getIngredients()) {
                sb.append(ingredient).append("\n");
            }

            sb.append("\nИнструкция приготовления:\n\n").append(recipe.getSteps()).append("\n\n");
        }

        try {
            File file = new File("recipes.txt");
            FileWriter writer = new FileWriter(file);
            writer.write(sb.toString());
            writer.close();
            return "Рецепты успешно скачаны в файл recipes.txt";
        } catch (IOException e) {
            e.printStackTrace();
            return "Ошибка при скачивании рецептов";
        }
    }
}
