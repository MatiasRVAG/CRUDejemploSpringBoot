package com.example.crudejemplo.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "pelicula")
public class Pelicula {
    public Pelicula() {
    }

    public Pelicula(Long id, String nombre, String categoria, float precio) {
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
    }

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Getter
    @Setter
    private String nombre;
    @Getter
    @Setter
    private String categoria;
    @Getter
    @Setter
    private float precio;

}
