package br.edu.ifsuldeminas.mch.webii.crudmanager.spring.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Length;
import jakarta.validation.constraints.Pattern;
import java.util.List;
import java.util.ArrayList;

@Entity
@Table(name = "usuarios")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotBlank(message = "O nome não pode ser vazio.")
    private String name;

    @NotBlank(message = "O email não pode ser vazio.")
    @Email(message = "Endereço de email inválido.")
    private String email;
    
    @NotBlank(message = "A senha não pode ser vazia.")
    @Length(min = 4, message = "A senha deve ter no mínimo 4 caracteres.")
    private String password;

    @NotBlank(message = "O gênero não pode ser vazio.")
    @Length(max = 1, message = "Gênero deve ter apenas 1 caractere.")
    @Pattern(regexp = "[MF]", message = "Gênero deve ser M ou F.")
    private String gender;

    @NotBlank(message = "O telefone não pode ser vazio.")
    @Length(max = 11, message = "Telefone deve ter no máximo 11 caracteres.")
    private String telefone;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ticket> tickets = new ArrayList<>();
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
    
    public String getPassword() { 
    	return password;
    }
    
    public void setPassword(String password) {
    	this.password = password; 
    }
}