package org.example.first.service.api.model;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * DTO for {@link org.example.first.service.client.entity.Category}
 */
@Data
@AllArgsConstructor
public class CategoryDto implements Serializable {
    private Integer id;
    @NotNull
    private String name;
}