package com.pacto.teste_tecnico.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pacto.teste_tecnico.domain.job.Job;
import com.pacto.teste_tecnico.service.JobService;

@RestController
@RequestMapping(value = "/job")
public class JobController {
    
    @Autowired
    private JobService jobService;

    @PostMapping
    public Job createJob(@RequestBody Job job) {
        job.setPublish_date(new Date());
        return jobService.createJob(job);
    }

    @PutMapping
    public Job updateJob(@RequestBody Job job) {
        return jobService.updateJob(job);
    }

    @DeleteMapping("/{jobId}")
    public void deleteJob(@PathVariable String jobId) {
        jobService.deleteJob(jobId);
    }

}
