package br.edu.ifsuldeminas.mch.webii.crudmanager.spring.controllers;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import br.edu.ifsuldeminas.mch.webii.crudmanager.spring.model.entities.Ticket;
import br.edu.ifsuldeminas.mch.webii.crudmanager.spring.model.repositories.*;
import jakarta.validation.Valid;

@Controller
public class TicketController {

    @Autowired private TicketRepository ticketRepository;
    @Autowired private MovieRepository movieRepository;
    @Autowired private UserRepository userRepository;

    @GetMapping("/tickets")
    public String listIngressos(Model model) {
        model.addAttribute("tickets", ticketRepository.findAll());
        return "tickets";
    }

    @GetMapping("/tickets/form")
    public String ingressoForm(@ModelAttribute("ticket") Ticket ticket, Model model) {
        model.addAttribute("movies", movieRepository.findAll());
        model.addAttribute("usuarios", userRepository.findAll());
        return "ticket_form";
    }

    @PostMapping("/tickets/save")
    public String ingressoSave(@ModelAttribute("ticket") @Valid Ticket ticket,
                               BindingResult errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("movies", movieRepository.findAll());
            model.addAttribute("usuarios", userRepository.findAll());
            return "ticket_form";
        }
        ticketRepository.save(ticket);
        return "redirect:/tickets";
    }

    @GetMapping("/tickets/{id}")
    public String ingressoUpdate(@PathVariable Integer id, Model model) {
    	ticketRepository.findById(id).ifPresent(i -> model.addAttribute("ticket", i));
        model.addAttribute("movies", movieRepository.findAll());
        model.addAttribute("usuarios", userRepository.findAll());
        return "ticket_form";
    }

    @GetMapping("/tickets/delete/{id}")
    public String ingressoDelete(@PathVariable Integer id) {
    	ticketRepository.findById(id).ifPresent(ticketRepository::delete);
        return "redirect:/tickets";
    }
}