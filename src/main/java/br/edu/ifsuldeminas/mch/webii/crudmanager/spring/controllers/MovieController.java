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
    private MovieRepository filmeRepository;

    @GetMapping("/filmes")
    public String listFilmes(Model model) {
        model.addAttribute("filmes", filmeRepository.findAll());
        return "filmes";
    }

    @GetMapping("/filmes/form")
    public String filmeForm(@ModelAttribute("filme") Movie movie) {
        return "filme_form";
    }

    @PostMapping("/filmes/save")
    public String filmeSave(@ModelAttribute("filme") @Valid Movie movie,
                            BindingResult errors) {
        if (errors.hasErrors()) return "filme_form";
        filmeRepository.save(movie);
        return "redirect:/filmes";
    }

    @GetMapping("/filmes/{id}")
    public String filmeUpdate(@PathVariable Integer id, Model model) {
        filmeRepository.findById(id).ifPresent(f -> model.addAttribute("filme", f));
        return "filme_form";
    }

    @GetMapping("/filmes/delete/{id}")
    public String filmeDelete(@PathVariable Integer id) {
        filmeRepository.findById(id).ifPresent(filmeRepository::delete);
        return "redirect:/filmes";
    }
}