package com.pacto.teste_tecnico.domain.user;

public enum UserRole {
    
    USER(0,"USER"),
    ADMIN(1,"ADMIN");

    private int codigo;
    private String role;
    
    private UserRole(int codigo, String role) {
        this.codigo = codigo;
        this.role = role;
    } 
    
    public String getRole() {
        return role;
    }

    public int getCodigo() {
        return codigo;
    }

    boolean enumOfValue(String role) {
        for (UserRole userRole : UserRole.values()) {
            if(userRole.name().toUpperCase().equals(role.toUpperCase())) return true ;
        }
        return false;
    }

}
