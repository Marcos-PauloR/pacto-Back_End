package com.pacto.teste_tecnico.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pacto.teste_tecnico.domain.company.Company;
import java.util.Optional;


public interface CompanyRepository extends JpaRepository<Company, String>{
    Optional<Company> findByEmail(String email);
}
