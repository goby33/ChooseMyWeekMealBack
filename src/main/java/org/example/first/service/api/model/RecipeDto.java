package org.example.first.service.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * DTO for {@link org.example.first.service.client.entity.Recipe}
 */
@Data
@AllArgsConstructor
public class RecipeDto implements Serializable {
    private Integer id;
    private String name;
    private CategoryDto category;
    private String imageUrl;
    private Set<RecipeIngredientDto> recipeIngredients = new LinkedHashSet<>();

}