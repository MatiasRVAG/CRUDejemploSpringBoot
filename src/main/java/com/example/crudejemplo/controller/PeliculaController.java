package com.example.crudejemplo.controller;

import com.example.crudejemplo.entity.Pelicula;
import com.example.crudejemplo.service.PeliculaServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PeliculaController  {


    @Autowired
    private PeliculaServiceImp peliculaServiceImp;

    @GetMapping(value = {"/home","/"})
    public String mostrarPeliculas(Model modelo){
        modelo.addAttribute("listaPeliculas",peliculaServiceImp.listarPeliculas());
        return "peliculas";
    }

    @GetMapping(value = "/peliculas/nuevo")
    public String mostrarPeliculaFormulario(Model modelo){
        Pelicula pelicula = new Pelicula();
        modelo.addAttribute("pelicula", pelicula);
        return "crear_pelicula";
    }

    @RequestMapping(value = "/peliculas", method = RequestMethod.POST)
    public String guardarPelicula(@ModelAttribute("pelicula") Pelicula pelicula){
        peliculaServiceImp.guardarPelicula(pelicula);
        return "redirect:/home";
    }

    @GetMapping(value = "/eliminar/{id}")
    public String eliminarPelicula(@PathVariable (name = "id")Long id){
        peliculaServiceImp.eliminarPelicua(id);
        return "redirect:/home";
    }
    @RequestMapping(value = "/editar/{id}")
    public ModelAndView mostrarFormularioEditar(@PathVariable (name = "id") Long id ){
        ModelAndView modelAndView = new ModelAndView("editar_pelicula");
        Pelicula pelicula = peliculaServiceImp.obtenerPelicula(id);
        modelAndView.addObject("pelicula", pelicula);
        return modelAndView;
    }



}

