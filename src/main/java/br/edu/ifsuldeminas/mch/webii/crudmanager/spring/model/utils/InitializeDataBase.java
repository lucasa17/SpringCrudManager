package br.edu.ifsuldeminas.mch.webii.crudmanager.spring.model.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import br.edu.ifsuldeminas.mch.webii.crudmanager.spring.model.entities.*;
import br.edu.ifsuldeminas.mch.webii.crudmanager.spring.model.repositories.*;

@Component
public class InitializeDataBase implements CommandLineRunner {

    @Autowired private UserRepository userRepository;
    @Autowired private MovieRepository filmeRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Override
    public void run(String... args) throws Exception {

        User emerson = new User();
        emerson.setName("Emerson Carvalho");
        emerson.setGender("M");
        emerson.setEmail("emerson@mail.com");
        emerson.setTelefone("35222222222");
        emerson.setPassword(passwordEncoder.encode("123456"));
        userRepository.save(emerson);

        User luiza = new User();
        luiza.setName("Luiza Carvalho");
        luiza.setGender("F");
        luiza.setEmail("lu@mail.com");
        luiza.setTelefone("35111111111");
        luiza.setPassword(passwordEncoder.encode("123456"));
        userRepository.save(luiza);

        userRepository.flush();

        Movie f1 = new Movie();
        f1.setTitulo("Interestelar");
        f1.setGenero("Ficção Científica");
        f1.setDuracao(169);
        f1.setClassificacao("12 anos");
        
        filmeRepository.save(f1);

        Movie f2 = new Movie();
        f2.setTitulo("O Poderoso Chefão");
        f2.setGenero("Drama");
        f2.setDuracao(175);
        f2.setClassificacao("16 anos");
        filmeRepository.save(f2);

        Movie f3 = new Movie();
        f3.setTitulo("Coringa");
        f3.setGenero("Suspense");
        f3.setDuracao(122);
        f3.setClassificacao("16 anos");
        filmeRepository.save(f3);

        filmeRepository.flush();
        
        
    }
}