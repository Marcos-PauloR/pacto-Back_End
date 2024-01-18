package com.pacto.teste_tecnico.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pacto.teste_tecnico.domain.candidate.Candidate;
import com.pacto.teste_tecnico.domain.company.Company;
import com.pacto.teste_tecnico.domain.job.Job;
import com.pacto.teste_tecnico.exception.ObjectNotFoundException;
import com.pacto.teste_tecnico.repository.CompanyRepository;
import com.pacto.teste_tecnico.repository.JobRepository;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private CompanyRepository companyRepository;

    public List<Job> getAllJobsByCompany(Company company) {
        return jobRepository.findByCompany(company);
    }

    public Job createJob(Job job) {
        if (job == null)
            throw new ObjectNotFoundException("Objeto sem valor ou não encontrado");
        var user = AuthorizationService.authenticated();
        if (user == null)
            throw new ObjectNotFoundException("Usuario Invalido");
        var company = companyRepository.findByEmail(user.getEmail());
        if (company == null)
            throw new ObjectNotFoundException("Nenhuma empresa encontrada");

        job.setCompany(company.get());
        return jobRepository.save(job);
    }

    public Job updateJob(Job job) {
        if (job.getId() == null || job.getId() != null) {
            return null;
        }
        var newJob = jobRepository.findById(job.getId()).orElse(null);
        updateJobData(newJob, job);
        return jobRepository.save(job);
    }

    private void updateJobData(Job newJob, Job job) {
        newJob.setCandidates(job.getCandidates());
        newJob.setCompany(job.getCompany());
        newJob.setDescription(job.getDescription());
        newJob.setExpiration_date(job.getExpiration_date());
        newJob.setTittle(job.getTittle());
        newJob.setPublish_date(job.getPublish_date());
        newJob.setRequirements(job.getRequirements());
    }

    private Job applyToJob(String jobId,Candidate candidate) {
        if(jobId==null) throw new ObjectNotFoundException("Vaga Inexistente!");
        if(candidate==null) throw new ObjectNotFoundException("Candidato Inexistente!");

        Job job = jobRepository.findById(jobId).orElse(null);
        if(job==null) throw new ObjectNotFoundException("Vaga Inexistente!");
        job.getCandidates().add(candidate);
        return jobRepository.save(job);

    }

    public void deleteJob(String jobId) {
        if (jobId == null)
            throw new ObjectNotFoundException("Objeto sem valor ou não encontrado");
        jobRepository.deleteById(jobId);
    }
}
