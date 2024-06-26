package org.example.first.service.api.controller;

import org.example.first.service.api.model.RecipeDto;
import org.example.first.service.business.contrat.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class RecipeController implements RecipeApi {

    @Autowired
    private RecipeService recipeService;

    @Override
    public ResponseEntity<List<RecipeDto>> getRecipes() {
        List<RecipeDto> recipes = recipeService.findAll();
        return new ResponseEntity<>(recipes, HttpStatus.ACCEPTED);
    }

    @Override
    public ResponseEntity<RecipeDto> getRecipeById(Integer recipeId) {
        //RecipeDto recipe = recipeService.findById(recipeId);
        return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
    }

    @Override
    public ResponseEntity<RecipeDto> createRecipe(RecipeDto recipeDto) {
        // RecipeDto recipe = recipeService.create(recipeDto);
        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<RecipeDto> updateRecipe(Integer recipeId, RecipeDto recipeDto) {
        // RecipeDto recipe = recipeService.update(recipeId, recipeDto);
        return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
    }

    @Override
    public ResponseEntity<Void> deleteRecipe(Integer recipeId) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
