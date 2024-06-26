package org.example.first.service.business.contrat;

import org.example.first.service.api.model.IngredientDto;
import org.example.first.service.client.entity.Ingredient;

import java.util.List;

public interface IngredientService {

    List<IngredientDto> findAll();


    IngredientDto findById(Integer ingredientId);


    IngredientDto create(IngredientDto ingredientDto);


    IngredientDto update(Integer ingredientId, IngredientDto ingredientDto);


    void delete(Integer ingredientId);
}
