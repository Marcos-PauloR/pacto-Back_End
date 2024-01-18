package com.pacto.teste_tecnico.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pacto.teste_tecnico.domain.candidate.Candidate;
import com.pacto.teste_tecnico.domain.job.Job;
import com.pacto.teste_tecnico.service.CandidateService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/candidate")
public class CandidateController {
    
    @Autowired
    private CandidateService candidateService;

    @PutMapping
    public Candidate updateCandidate(@Valid @RequestBody  Candidate updatedCandidate) {
        return candidateService.updateCandidate(updatedCandidate);
    }

    @DeleteMapping("/{candidateId}")
    public void deleteCandidate(@PathVariable String candidateId) {
        candidateService.deleteCandidate(candidateId);
    }
    @GetMapping("/{candidateId}/jobsApplied")
    public List<Job> getJobsAppliedByCandidate(@PathVariable String candidateId) {
        return candidateService.getJobsAppliedByCandidate(candidateId);
    }
}
