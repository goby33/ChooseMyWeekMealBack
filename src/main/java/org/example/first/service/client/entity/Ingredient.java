package org.example.first.service.client.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "ingredient")
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ingredient_id_gen")
    @SequenceGenerator(name = "ingredient_id_gen", sequenceName = "ingredient_ingredient_id_seq", allocationSize = 1)
    @Column(name = "ingredient_id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 20)
    private String name;

    @Column(name = "image_url", length = 100)
    private String imageUrl;

}