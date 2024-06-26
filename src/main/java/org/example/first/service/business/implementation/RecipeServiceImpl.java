package org.example.first.service.business.implementation;

import org.example.first.service.api.model.*;
import org.example.first.service.business.contrat.RecipeService;
import org.example.first.service.client.entity.Recipe;
import org.example.first.service.client.entity.RecipeIngredient;
import org.example.first.service.client.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecipeServiceImpl implements RecipeService {
    @Autowired
    private RecipeRepository recipeRepository;

    @Override
    public List<RecipeDto> findAll() {
        List<Recipe> recipeList = recipeRepository.findAll();
        return recipeList.stream().map(recipe ->
                new RecipeDto(
                        recipe.getId(),
                        recipe.getName(),
                        new CategoryDto(
                                recipe.getCategory().getId(),
                                recipe.getCategory().getName()
                        ),
                        recipe.getImageUrl(),
                        recipe.getRecipeIngredients().stream().map(recipeIngredient ->
                                new RecipeIngredientDto(
                                        new IngredientDto(
                                                recipeIngredient.getIngredient().getId(),
                                                recipeIngredient.getIngredient().getName(),
                                                recipeIngredient.getIngredient().getImageUrl()
                                        ),
                                        recipeIngredient.getQuantity(),
                                       new UnitDto(
                                                recipeIngredient.getUnit().getId(),
                                                recipeIngredient.getUnit().getName()
                                        )
                                )).collect(Collectors.toSet())
                )
        ).collect(Collectors.toList());
    }

}

