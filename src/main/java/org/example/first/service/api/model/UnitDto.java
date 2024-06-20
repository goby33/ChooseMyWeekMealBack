package org.example.first.service.api.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

/**
 * DTO for {@link org.example.first.service.client.entity.Unit}
 */

public record UnitDto(@NotNull @NotEmpty String name) implements Serializable {
}