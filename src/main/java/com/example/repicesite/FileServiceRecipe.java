package com.example.repicesite;

import com.example.repicesite.dto.RecipeDTO;

import java.io.File;
import java.util.List;

public interface FileServiceRecipe {
    boolean saveToFile(String json);

    String readFromFile();

    List<RecipeDTO> getAllRecipes();

    File downloadRecipes();
}
