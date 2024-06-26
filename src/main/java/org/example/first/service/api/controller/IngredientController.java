package org.example.first.service.api.controller;

import org.example.first.service.api.model.IngredientDto;
import org.example.first.service.business.contrat.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class IngredientController implements IngredientApi {

    @Autowired
    private IngredientService ingredientService;

    @Override
    public ResponseEntity<List<IngredientDto>> getIngredients() {
        List<IngredientDto> ingredients = ingredientService.findAll();
        return new ResponseEntity<>(ingredients, HttpStatus.ACCEPTED);
    }

    @Override
    public ResponseEntity<IngredientDto> getIngredientById(Integer ingredientId) {
        IngredientDto ingredient = ingredientService.findById(ingredientId);
        return new ResponseEntity<>(ingredient, HttpStatus.ACCEPTED);
    }

    @Override
    public ResponseEntity<IngredientDto> createIngredient(IngredientDto ingredientDto) {
        IngredientDto ingredient = ingredientService.create(ingredientDto);
        return new ResponseEntity<>(ingredient, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<IngredientDto> updateIngredient(Integer ingredientId, IngredientDto ingredientDto) {
        IngredientDto ingredient = ingredientService.update(ingredientId, ingredientDto);
        return new ResponseEntity<>(ingredient, HttpStatus.ACCEPTED);
    }

    @Override
    public ResponseEntity<Void> deleteIngredient(Integer ingredientId) {
        ingredientService.delete(ingredientId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
