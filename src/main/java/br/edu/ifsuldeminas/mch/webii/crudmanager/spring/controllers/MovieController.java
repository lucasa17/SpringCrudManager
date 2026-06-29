package br.edu.ifsuldeminas.mch.webii.crudmanager.spring.controllers;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import br.edu.ifsuldeminas.mch.webii.crudmanager.spring.model.entities.Movie;
import br.edu.ifsuldeminas.mch.webii.crudmanager.spring.model.repositories.MovieRepository;
import jakarta.validation.Valid;

@Controller
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;

    @GetMapping("/movies")
    public String listFilmes(Model model) {
        model.addAttribute("movies", movieRepository.findAll());
        return "movies";
    }

    @GetMapping("/movies/form")
    public String filmeForm(@ModelAttribute("movie") Movie movie) {
        return "movie_form";  // era "movies_form"
    }

    @PostMapping("/movie/save")
    public String filmeSave(@ModelAttribute("movie") @Valid Movie movie,
                            BindingResult errors) {
        if (errors.hasErrors()) return "movie_form";
        movieRepository.save(movie);
        return "redirect:/movies";
    }

    @GetMapping("/movies/{id}")
    public String filmeUpdate(@PathVariable Integer id, Model model) {
    	movieRepository.findById(id).ifPresent(f -> model.addAttribute("movie", f));
        return "movie_form";
    }

    @GetMapping("/movies/delete/{id}")
    public String filmeDelete(@PathVariable Integer id) {
    	movieRepository.findById(id).ifPresent(movieRepository::delete);
        return "redirect:/movies";
    }
}