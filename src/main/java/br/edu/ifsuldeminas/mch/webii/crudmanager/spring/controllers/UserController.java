package br.edu.ifsuldeminas.mch.webii.crudmanager.spring.controllers;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import br.edu.ifsuldeminas.mch.webii.crudmanager.spring.model.entities.User;
import br.edu.ifsuldeminas.mch.webii.crudmanager.spring.model.repositories.UserRepository;
import jakarta.validation.Valid;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public String listUsers(Model model) {
        model.addAttribute("usuarios", userRepository.findAll());
        return "users";
    }

    @GetMapping("/users/form")
    public String userForm(@ModelAttribute("user") User user) {
        return "user_form";
    }

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/users/save")
    public String userSave(@ModelAttribute("user") @Valid User user,
                           BindingResult errors) {
        if (errors.hasErrors()) return "user_form";
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return "redirect:/users";
    }

    @GetMapping("/users/{id}")
    public String userUpdate(@PathVariable Integer id, Model model) {
        userRepository.findById(id).ifPresent(u -> model.addAttribute("user", u));
        return "user_form";
    }

    @GetMapping("/users/delete/{id}")
    public String userDelete(@PathVariable Integer id) {
        userRepository.findById(id).ifPresent(userRepository::delete);
        return "redirect:/users";
    }
}