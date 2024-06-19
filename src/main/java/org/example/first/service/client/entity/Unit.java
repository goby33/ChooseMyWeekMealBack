package org.example.first.service.client.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "unit")
public class Unit {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "unit_id_gen")
    @SequenceGenerator(name = "unit_id_gen", sequenceName = "unit_unit_id_seq", allocationSize = 1)
    @Column(name = "unit_id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 20)
    private String name;

}