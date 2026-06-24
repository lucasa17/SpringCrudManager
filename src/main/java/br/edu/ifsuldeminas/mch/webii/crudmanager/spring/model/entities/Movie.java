package br.edu.ifsuldeminas.mch.webii.crudmanager.spring.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity(name = "movie")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotBlank(message = "O título não pode ser vazio.")
    private String titulo;

    @NotBlank(message = "O gênero não pode ser vazio.")
    private String genero;

    @NotNull(message = "A duração não pode ser vazia.")
    @Min(value = 1, message = "A duração deve ser maior que zero.")
    private Integer duracao;

    @NotBlank(message = "A classificação não pode ser vazia.")
    private String classificacao;

    public Movie() {}

    public Integer getId() { 
    	return id; 
    }
    
    public void setId(Integer id) {
    	this.id = id;
    }
    
    public String getTitulo() { 
    	return titulo; 
    }
    
    public void setTitulo(String titulo) {
    	this.titulo = titulo;
    }
    
    public String getGenero() { 
    	return genero;
    }
    
    public void setGenero(String genero) {
    	this.genero = genero; 
    }
    
    public Integer getDuracao() { 
    	return duracao; 
    }
    
    public void setDuracao(Integer duracao) { 
    	this.duracao = duracao; 
    }
    
    public String getClassificacao() { 
    	return classificacao; 
    }
    
    public void setClassificacao(String classificacao) { 
    	this.classificacao = classificacao; 
    }
}