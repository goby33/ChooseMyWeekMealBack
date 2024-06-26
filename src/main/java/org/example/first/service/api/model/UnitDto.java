package org.example.first.service.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link org.example.first.service.client.entity.Unit}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UnitDto implements Serializable {
    private Integer id;
    private String name;
}