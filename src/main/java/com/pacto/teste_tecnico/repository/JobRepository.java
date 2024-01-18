package com.pacto.teste_tecnico.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pacto.teste_tecnico.domain.company.Company;
import com.pacto.teste_tecnico.domain.job.Job;

public interface JobRepository extends JpaRepository<Job, String> {
    List<Job> findByCompany(Company company);
}
