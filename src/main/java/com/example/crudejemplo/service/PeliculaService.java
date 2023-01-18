package com.example.crudejemplo.service;

import com.example.crudejemplo.entity.Pelicula;

import java.util.List;

public interface PeliculaService  {

    public List<Pelicula> listarPeliculas();

    public void guardarPelicula(Pelicula pelicula);

   public void eliminarPelicua(Long id);

   public Pelicula obtenerPelicula(Long id);

}
