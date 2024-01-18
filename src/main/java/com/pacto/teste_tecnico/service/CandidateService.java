package com.pacto.teste_tecnico.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pacto.teste_tecnico.domain.candidate.Candidate;
import com.pacto.teste_tecnico.domain.job.Job;
import com.pacto.teste_tecnico.exception.ObjectNotFoundException;
import com.pacto.teste_tecnico.repository.CandidateRepository;
import com.pacto.teste_tecnico.repository.JobRepository;


@Service
public class CandidateService {

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private JobRepository jobRepository;

    public Candidate updateCandidate(Candidate updatedCandidate) {
        if (updatedCandidate == null)
            throw new ObjectNotFoundException("Objeto sem valor ou não encontrado");
        if (updatedCandidate.getId() == null)
            throw new ObjectNotFoundException("Objeto sem valor ou não encontrado");
        var newCandidate = candidateRepository.findById(updatedCandidate.getId()).orElse(null);
        updateCandiateData(newCandidate, updatedCandidate);
        return candidateRepository.save(newCandidate);
    }

    private void updateCandiateData(Candidate newCandidate, Candidate updatedCandidate) {
        newCandidate.setContato(updatedCandidate.getContato());
        newCandidate.setHabilidade(updatedCandidate.getHabilidade());
        newCandidate.setJobs(updatedCandidate.getJobs());
        newCandidate.setEmail(updatedCandidate.getEmail());
        newCandidate.setNome(updatedCandidate.getNome());
        newCandidate.setPassword(new BCryptPasswordEncoder().encode(updatedCandidate.getPassword()));
        newCandidate.setRole(updatedCandidate.getRole());
        newCandidate.setJobs(updatedCandidate.getJobs());
    }

    public void deleteCandidate(String candidateId) {
        if (candidateId == null)
            throw new ObjectNotFoundException("Objeto sem valor ou não encontrado");
        candidateRepository.deleteById(candidateId);
    }

    // @Transactional
    // public List<Job> applyToJob(String candidateId, String jobId) {
    //     if (candidateId == null || jobId == null)
    //         throw new ObjectNotFoundException("Objeto sem valor ou não encontrado");
    //     Candidate candidate = candidateRepository.findById(candidateId).orElse(null);

    //     Job job = jobRepository.findById(jobId).orElse(null);

    //     if (candidate != null && job != null) {
    //         var lista = candidate.getJobs();
    //         lista.add(job);
    //         return jobRepository.saveAll(lista);
    //     } else {
    //         return null;
    //     }
    // }

    public List<Job> getJobsAppliedByCandidate(String candidateId) {

        if (candidateId == null)
            throw new ObjectNotFoundException("Objeto sem valor ou não encontrado");
        Candidate candidate = candidateRepository.findById(candidateId).orElse(null);

        if (candidate != null) {
            return candidate.getJobs();
        } else {
            return Collections.emptyList();
        }
    }

}
