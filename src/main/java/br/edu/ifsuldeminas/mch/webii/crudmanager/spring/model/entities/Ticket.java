package br.edu.ifsuldeminas.mch.webii.crudmanager.spring.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity(name = "ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull(message = "A data não pode ser vazia.")
    private LocalDate dataIngresso;

    @NotNull(message = "O horário não pode ser vazio.")
    private LocalTime horario;

    @NotBlank(message = "A sala não pode ser vazia.")
    private String sala;

    @NotNull(message = "O preço não pode ser vazio.")
    @DecimalMin(value = "0.01", message = "O preço deve ser maior que zero.")
    private BigDecimal preco;

    @NotNull(message = "Selecione um usuário.")
    @ManyToOne(optional = false)
    @JoinColumn(name = "idUsuario")
    private User usuario;

    @NotNull(message = "Selecione um filme.")
    @ManyToOne(optional = false)
    @JoinColumn(name = "idFilme")
    private Movie movie;

    public Ticket() {}

    public Integer getId() { 
    	return id;
    }
    
    public void setId(Integer id) { 
    	this.id = id; 
    }
    
    public LocalDate getDataIngresso() { 
    	return dataIngresso; 
    }
    
    public void setDataIngresso(LocalDate dataIngresso) { 
    	this.dataIngresso = dataIngresso; 
    }
    
    public LocalTime getHorario() { 
    	return horario; 
    }
    
    public void setHorario(LocalTime horario) { 
    	this.horario = horario; 
    }
    
    public String getSala() { 
    	return sala; 
    }
    
    public void setSala(String sala) {
    	this.sala = sala; 
    }
    
    public BigDecimal getPreco() { 
    	return preco; 
    }
    
    public void setPreco(BigDecimal preco) { 
    	this.preco = preco; 
    }
    
    public Movie getMovie() { 
    	return movie; 
    }
    public void setMovie(Movie movie) { 
    	this.movie = movie;
    }
    
    public User getUsuario() { 
    	return usuario; 
    }
    
    public void setUsuario(User usuario) { 
    	this.usuario = usuario; 
    }
}