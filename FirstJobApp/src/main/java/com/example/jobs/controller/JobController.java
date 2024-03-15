package com.example.jobs.controller;

import com.example.jobs.models.Job;
import com.example.jobs.service.JobService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JobController {

    private JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("/jobs")
    public ResponseEntity<List<Job>> findAll(){
        return ResponseEntity.ok(jobService.findAll());
    }

    @PostMapping("/jobs")
    public ResponseEntity createJob(@RequestBody Job job){
        jobService.createJob(job);
        return new ResponseEntity<>("job created successfully!!!",HttpStatus.CREATED);
    }

    @GetMapping("/jobs/{Id}")
    public ResponseEntity<Job> getJobById(@PathVariable  Long Id){
        Job job = jobService.getJobById(Id);
        if (job!=null){
            return new ResponseEntity<>(job, HttpStatus.OK);
        }
        return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/jobs/{Id}")
    public ResponseEntity<String> deleteJobById(@PathVariable Long Id){
        boolean deleted = jobService.deleteJobById(Id);
        if (deleted){
            return new ResponseEntity<>("Job deleted successfully",HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/jobs/{Id}")
    public ResponseEntity<String> updateJob(@PathVariable Long Id, @RequestBody Job updatedJob){
        boolean updated = jobService.updateJob(Id,updatedJob);
        if (updated){
            return new ResponseEntity<>("Job updated successfully",HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
