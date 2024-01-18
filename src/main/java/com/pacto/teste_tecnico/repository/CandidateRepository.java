package com.pacto.teste_tecnico.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.pacto.teste_tecnico.domain.candidate.Candidate;



public interface CandidateRepository extends JpaRepository<Candidate, String> {
 

}
