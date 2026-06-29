package br.edu.ifsuldeminas.mch.webii.crudmanager.spring.config;

import br.edu.ifsuldeminas.mch.webii.crudmanager.spring.model.entities.Movie;
import br.edu.ifsuldeminas.mch.webii.crudmanager.spring.model.entities.User;
import br.edu.ifsuldeminas.mch.webii.crudmanager.spring.model.repositories.MovieRepository;
import br.edu.ifsuldeminas.mch.webii.crudmanager.spring.model.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired private MovieRepository movieRepository;
    @Autowired private UserRepository userRepository;

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new Converter<String, Movie>() {
            public Movie convert(String id) {
                if (id == null || id.isBlank()) return null;
                return movieRepository.findById(Integer.parseInt(id)).orElse(null);
            }
        });
        registry.addConverter(new Converter<String, User>() {
            public User convert(String id) {
                if (id == null || id.isBlank()) return null;
                return userRepository.findById(Integer.parseInt(id)).orElse(null);
            }
        });
    }
}