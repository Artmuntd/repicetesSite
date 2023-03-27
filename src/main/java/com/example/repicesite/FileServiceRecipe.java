package com.example.repicesite;

public interface FileServiceRecipe {
    boolean saveToFile(String json);

    String readFromFile();
}
