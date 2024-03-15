package com.example.jobs.Implementation;

import com.example.jobs.models.Job;
import com.example.jobs.service.JobService;
import org.springframework.boot.autoconfigure.orm.jpa.JpaBaseConfiguration;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class JobServiceImpl implements JobService {

    private List<Job> jobs = new ArrayList<>();

    private Long nextId=1L;

    @Override
    public List<Job> findAll() {
        return jobs;
    }

    @Override
    public void createJob(Job job) {
        job.setId(nextId++);
        jobs.add(job);
    }

    @Override
    public Job getJobById(Long Id) {
        for (Job job:jobs) {
            if (job.getId().equals(Id)){
                return job;
            }
        }
        return null;
    }

    @Override
    public boolean deleteJobById(Long Id) {
        Iterator<Job> jobIterator = jobs.iterator();
        while (jobIterator.hasNext()){
            Job job = jobIterator.next();
            if (job.getId().equals(Id)){
                jobIterator.remove();
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean updateJob(Long Id, Job updatedJob) {
        for (Job job: jobs) {
            if (job.getId().equals(Id)){
                job.setTitle(updatedJob.getTitle());
                job.setDescription(updatedJob.getDescription());
                job.setMinSalary(updatedJob.getMinSalary());
                job.setMaxSalary(updatedJob.getMaxSalary());
                job.setLocation(updatedJob.getLocation());
                return true;
            }
        }
        return false;
    }

}
