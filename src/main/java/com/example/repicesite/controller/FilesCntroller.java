package com.example.repicesite.controller;

import com.example.repicesite.service.FileServiceIngredient;
import com.example.repicesite.service.FileServiceRecipe;
import org.apache.commons.io.IOUtils;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@RestController
@RequestMapping("/files")
public class FilesCntroller {
    private final FileServiceRecipe fileServiceRecipe;
    private  final FileServiceIngredient fileServiceIngredient;

    public FilesCntroller(FileServiceRecipe fileServiceRecipe, FileServiceIngredient fileServiceIngredient) {
        this.fileServiceRecipe = fileServiceRecipe;


        this.fileServiceIngredient = fileServiceIngredient;
    }

    @GetMapping("/exportRecipe")
    public ResponseEntity<InputStreamResource> dowloadDatafile() throws FileNotFoundException {
        File file = fileServiceRecipe.getDatafile();
        if (file.exists()) {
            InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_JSON)
                    .contentLength(file.length())
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename =\"Recipes.json\"")
                    .body(resource);
        } else {
            return ResponseEntity.noContent().build();
        }
    }
    @PostMapping(value = "/importRecipe", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public  ResponseEntity<Void> uploadDataFile(@RequestParam MultipartFile file){
        fileServiceRecipe.CleanDataFile();
        File dataFile = fileServiceRecipe.getDatafile();
        try(FileOutputStream fos = new FileOutputStream(dataFile)){
            IOUtils.copy(file.getInputStream(),fos);
            return  ResponseEntity.ok().build();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();





    }
    @PostMapping(value = "/importIngredient", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public  ResponseEntity<Void> uploadDataFileIngredient(@RequestParam MultipartFile file){
        fileServiceIngredient.CleanDataFile();
        File dataFileIngredient = fileServiceRecipe.getDatafile();
        try(FileOutputStream fos = new FileOutputStream(dataFileIngredient)){
            IOUtils.copy(file.getInputStream(),fos);
            return  ResponseEntity.ok().build();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();





    }
}
