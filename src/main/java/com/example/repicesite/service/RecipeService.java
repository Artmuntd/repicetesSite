package com.example.repicesite.service;

import com.example.repicesite.dto.RecipeDTO;
import com.example.repicesite.model.Recipe;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.io.File;
import java.util.*;
@Service
public class RecipeService {

 final  private  FileServiceRecipe fileServiceRecipe;

    public RecipeService(FileServiceRecipe fileServiceRecipe) {
        this.fileServiceRecipe = fileServiceRecipe;
    }

    private int idCounter = 0;

    private Map<Integer, Recipe> recipes = new HashMap<>();



    public RecipeDTO addRecipe(Recipe recipe){
      int id = idCounter++;
      recipes.put(id, recipe);
      saveToFile();
      return  RecipeDTO.from(id, recipe);
    }


    @PostConstruct
    public void init(){
      readFromFile();
    }

    public RecipeDTO getRecipe(int id) {
        Recipe recipe = recipes.get(id);
        if (recipe != null){
            return  RecipeDTO.from(id, recipe);
        }
        return  null;
    }

    public List<RecipeDTO> getAllRecipes() {
        List<RecipeDTO> result = new ArrayList<>();
        for (Map.Entry<Integer, Recipe> entry : recipes.entrySet()) {
            try {
                result.add(RecipeDTO.from(entry.getKey(), entry.getValue()));
            } catch (NullPointerException e) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Рецепт с id " + entry.getKey() + " не найден");
            } catch (IllegalArgumentException e) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Рецепт  не найден " + entry.getKey() );
            }
        }
        return result;
    }

    public RecipeDTO updateRecipe(int id, Recipe recipe) {
        Recipe pathRecipe = recipes.get(id);
        if(pathRecipe == null){
            throw new RecipeNotFound();
        }
        recipes.put(id,recipe);
        saveToFile();
        return  RecipeDTO.from(id, recipe);
    }

    public RecipeDTO deleteById(int id) {
        Recipe deleteRecipe = recipes.remove(id);
        if( deleteRecipe == null){
            throw new RecipeNotFound();
        }
        saveToFile();
      return  RecipeDTO.from(id, deleteRecipe);
    }
    public  void deleteAllRecipe(){
        recipes = new TreeMap<>();
    }

        public ResponseEntity<Resource> downloadRecipes() {
            File file = fileServiceRecipe.downloadRecipes();

            if (file != null) {
                Resource resource = (Resource) new FileSystemResource(file);
                HttpHeaders headers = new HttpHeaders();
                headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=recipes.txt");
                return ResponseEntity.ok()
                        .headers(headers)
                        .contentLength(file.length())
                        .contentType(MediaType.parseMediaType("application/octet-stream"))
                        .body(resource);
            } else {
                return ResponseEntity.notFound().build();
            }
        }



    private  void  saveToFile(){
        try {
        String json =  new ObjectMapper().writeValueAsString(recipes);
        fileServiceRecipe.saveToFile(json);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }

   private  void readFromFile(){
     String json = fileServiceRecipe.readFromFile();
       try {
          recipes = new ObjectMapper().readValue(json, new TypeReference<Map<Integer,Recipe>>() {
           });
       } catch (JsonProcessingException e) {
           throw new RuntimeException(e);
       }
   }

}
