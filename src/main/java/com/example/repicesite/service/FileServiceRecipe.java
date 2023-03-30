package com.example.repicesite.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class FileServiceRecipe implements com.example.repicesite.FileServiceRecipe {
    @Value("${path.to.recipes.file}")
    private String recipeFillePath;
    @Value("${name.of.recipes.file}")
    private String recipeFileName;


    @Override
    public boolean saveToFile(String json){
        try {
            CleanDataFile();
            Files.writeString(Path.of(recipeFillePath ,recipeFileName), json);
            return  true;
        } catch (IOException e) {
            return false;
        }
    }
    @Override
    public String readFromFile(){
        try {
            return  Files.readString(Path.of(recipeFillePath, recipeFileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public File getDatafile(){
        return  new File(recipeFillePath + "/" + recipeFileName);
    }

    public boolean CleanDataFile() {

        try {
            Path path = Path.of(recipeFillePath, recipeFileName);
            Files.deleteIfExists(path);
            Files.createFile(path);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return  false;
        }

    }

}
