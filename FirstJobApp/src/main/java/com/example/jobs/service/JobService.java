package com.example.jobs.service;

import com.example.jobs.models.Job;

import java.util.List;

public interface JobService {
    List<Job> findAll();
    void createJob(Job job
    );

    Job getJobById(Long Id);

    boolean deleteJobById(Long Id);

    boolean updateJob(Long Id, Job updatedJob);
}
