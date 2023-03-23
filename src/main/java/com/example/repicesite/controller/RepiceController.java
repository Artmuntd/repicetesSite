package com.example.repicesite.controller;


import com.example.repicesite.model.Repice;
import com.example.repicesite.service.RepiceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/recipe")
public class RepiceController {
    private  final RepiceService recipeService;

    public RepiceController(RepiceService recipeService) {
        this.recipeService = recipeService;
    }
    @GetMapping("/all")
    public  Repice getAllRecipe(){
        return  recipeService.getAllRecipe();
    }
    @GetMapping("/{id}")
    public Repice getRepice(@PathVariable("id") int id) {
      return  recipeService.getRecipe(id);
 }
   @PostMapping()
    public Repice  addRecipe(@RequestBody Repice repice){
      return    recipeService.addRecipe(repice);
   }
   @DeleteMapping("{id}")
   public ResponseEntity<Void> deleteRcipe(@PathVariable int id){
        if(recipeService.deleteRecipe(id)){
            return ResponseEntity.ok().build();
        }
        return  ResponseEntity.notFound().build();
   }
   @DeleteMapping()
    public ResponseEntity<Void> deleteAllRecipe(){
        recipeService.deleteAllRecipe();
        return ResponseEntity.ok().build();
   }
}
