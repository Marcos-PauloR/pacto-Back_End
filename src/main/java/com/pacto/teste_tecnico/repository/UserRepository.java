package com.pacto.teste_tecnico.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.pacto.teste_tecnico.domain.user.Users;


public interface UserRepository extends JpaRepository<Users, String> {

    UserDetails findByEmail(String email);
    Users findUserByEmail(String email);   

}
