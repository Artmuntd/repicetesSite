package com.example.repicesite.controller;

import com.example.repicesite.model.Repice;
import com.example.repicesite.service.RepiceService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/recipe")
public class RepiceController {
    private  final RepiceService recipeService;

    public RepiceController(RepiceService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/{id}")
    public Repice getRepice(@PathVariable("id") int id) {
      return  recipeService.getRepice(id);
 }
   @PostMapping()
    public Repice addRecipe(@RequestBody Repice repice){
        return recipeService.addRepice(repice);
   }
}
