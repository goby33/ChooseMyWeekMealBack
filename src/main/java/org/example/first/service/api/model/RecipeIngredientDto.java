package org.example.first.service.api.model;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link org.example.first.service.client.entity.RecipeIngredient}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecipeIngredientDto implements Serializable {
    @NotNull
    private IngredientDto ingredient;
    @NotNull
    private Integer quantity;
    private UnitDto unit;
}