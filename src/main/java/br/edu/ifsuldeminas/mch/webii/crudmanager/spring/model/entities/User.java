package br.edu.ifsuldeminas.mch.webii.crudmanager.spring.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Length;

@Entity(name = "usuarios")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotBlank(message = "O nome não pode ser vazio.")
    private String name;

    @NotBlank(message = "O email não pode ser vazio.")
    @Email(message = "Endereço de email inválido.")
    private String email;

    @NotBlank(message = "O telefone não pode ser vazio.")
    @Length(max = 15, message = "Telefone deve ter no máximo 15 caracteres.")
    private String telefone;

    @NotBlank(message = "O gênero não pode ser vazio.")
    @Length(max = 1, message = "Gênero deve ter apenas 1 caractere.")
    private String gender;
    
    public User() {
    	
    }

    public Integer getId() { 
    	return id; 
    }
    
    public void setId(Integer id) { 
    	this.id = id; 
    }
    
    public String getName() { 
    	return name; 
    }
    
    public void setName(String name) { 
    	this.name = name;
    }
    
    public String getEmail() {
    	return email; 
    }
    
    public void setEmail(String email) {
    	this.email = email;
    }
    
    public String getTelefone() {
    	return telefone; 
    }
    
    public void setTelefone(String telefone) { 
    	this.telefone = telefone; 
    }
    
    public String getGender() { 
    	return gender; 
    }
    
    public void setGender(String gender) { 
    	this.gender = gender; 
    }
}