package org.example.first.service.business.contrat;

import org.example.first.service.api.model.RecipeDto;

import java.util.List;

public interface RecipeService {

    List<RecipeDto> findAll();
}
