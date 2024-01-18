package com.pacto.teste_tecnico.domain.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class RegisterDTO {
    
    @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}",message = "Deve ser um email válido!")
    @NotBlank
    private String email;
    @NotBlank
    private String nome;
    @NotBlank
    private String password; 
    private UserRole role;


    public RegisterDTO() {
        
    }

    public RegisterDTO(String email, String password, String nome,UserRole role) {
        this.email = email;
        this.password = password;
        this.nome = nome;
        this.role = role;
    }


    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public UserRole getRole() {
        return role;
    }
    public void setRole(UserRole role) {
        this.role = role;
    }
    
}