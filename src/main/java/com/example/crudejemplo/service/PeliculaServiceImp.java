package com.example.crudejemplo.service;

import com.example.crudejemplo.entity.Pelicula;
import com.example.crudejemplo.repository.PeliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeliculaServiceImp implements PeliculaService {

    @Autowired
    private PeliculaRepository peliculaRepository;

    @Override
    public List<Pelicula> listarPeliculas() {
        return peliculaRepository.findAll();
    }

    @Override
    public void guardarPelicula(Pelicula pelicula) {
        peliculaRepository.save(pelicula);
    }

    @Override
    public void eliminarPelicua(Long id) {
        peliculaRepository.deleteById(id);
    }

    @Override
    public Pelicula obtenerPelicula(Long id) {
       return peliculaRepository.findById(id).get();
    }

}
