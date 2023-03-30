package com.example.repicesite;

import java.io.File;

public interface FileServiceRecipe {
    boolean saveToFile(String json);

    String readFromFile();

    File getDatafile();
}
