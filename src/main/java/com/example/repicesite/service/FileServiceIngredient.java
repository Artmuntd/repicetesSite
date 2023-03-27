package com.example.repicesite.service;

import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileServiceIngredient  implements com.example.repicesite.FileServiceIngredient {
    @Value("${path.to.ingedients.file}")
    private String ingedientsFillePath;
    @Value("${name.of.ingedients.file}")
    private String ingedientsFileName;


    @Override
    public boolean saveToFile(String json) {
        try {
            CleanDataFile();
            Files.writeString(Path.of(ingedientsFillePath ,ingedientsFileName), json);
            return  true;
        } catch (IOException e) {
            return false;
        }
    }



    @Override
    public String readFromFile(){
        try {
            return  Files.readString(Path.of(ingedientsFillePath, ingedientsFileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean CleanDataFile() {

        try {
            Path path = Path.of(ingedientsFillePath, ingedientsFileName);
            Files.deleteIfExists(path);
            Files.createFile(path);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return  false;
        }

    }

















}
