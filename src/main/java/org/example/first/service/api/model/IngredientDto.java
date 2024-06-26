package org.example.first.service.api.model;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link org.example.first.service.client.entity.Ingredient}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IngredientDto implements Serializable {
    private Integer id;
    private String name;
    @NotNull
    private String imageUrl;
}