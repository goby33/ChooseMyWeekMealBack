package org.example.first.service.business.implementation;

import org.example.first.service.api.model.IngredientDto;
import org.example.first.service.business.contrat.IngredientService;
import org.example.first.service.client.entity.Ingredient;
import org.example.first.service.client.repository.CategoryRepository;
import org.example.first.service.client.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IngredientServiceImpl implements IngredientService {
    @Autowired
    private IngredientRepository ingredientRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<IngredientDto> findAll() {
        List<Ingredient> ingredients = ingredientRepository.findAll();
        return ingredients.stream().map(ingredient -> new IngredientDto(ingredient.getId(), ingredient.getName(), ingredient.getImageUrl())).collect(Collectors.toList());
    }

    @Override
    public IngredientDto findById(Integer ingredientId) {
        return ingredientRepository.findById(ingredientId).map(ingredient -> new IngredientDto(ingredient.getId(), ingredient.getName(), ingredient.getImageUrl())).orElse(null);
    }

    @Override
    public IngredientDto create(IngredientDto ingredientDto) {
        Ingredient ingredient = new Ingredient();
        ingredient.setName(ingredientDto.getName());
        ingredient.setImageUrl(ingredientDto.getImageUrl());
        ingredientRepository.save(ingredient);
        return new IngredientDto(ingredient.getId(), ingredient.getName(), ingredient.getImageUrl());
    }

    @Override
    public IngredientDto update(Integer ingredientId, IngredientDto ingredientDto) {
        return ingredientRepository.findById(ingredientId).map(ingredient -> {
            ingredient.setName(ingredientDto.getName());
            ingredient.setImageUrl(ingredientDto.getImageUrl());
            ingredientRepository.save(ingredient);
            return new IngredientDto(ingredient.getId(), ingredient.getName(), ingredient.getImageUrl());
        }).orElse(null);
    }

    @Override
    public void delete(Integer ingredientId) {
        ingredientRepository.deleteById(ingredientId);
    }

}
