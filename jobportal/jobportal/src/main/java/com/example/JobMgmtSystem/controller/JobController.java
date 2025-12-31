package com.example.JobMgmtSystem.controller;

import com.example.JobMgmtSystem.entity.Job;
import com.example.JobMgmtSystem.response.ApiResponse;
import com.example.JobMgmtSystem.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/jobs")

public class JobController
{
    @Autowired
    private JobService service;

    @PostMapping
    public ResponseEntity<ApiResponse<Job>> createJob(@RequestBody Job job)
    {
        Job saved = service.createJob(job);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse<>("Job created", LocalDateTime.now(), saved));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Job>> getJob(@PathVariable Long id)
    {
        Job job = service.getJobById(id);
        return ResponseEntity.ok(
                new ApiResponse<>("Job found", LocalDateTime.now(), job));

    }

    @GetMapping("/company/{company}")
    public ResponseEntity<ApiResponse<List<Job>>> getByCompany(@PathVariable String company)
    {
        List<Job> jobs = service.getJobsByCompany(company);
        return ResponseEntity.ok(
                new ApiResponse<>("Jobs List", LocalDateTime.now(), jobs));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Job>> updateJob(@PathVariable Long id, @RequestBody Job job)
    {
        Job updated = service.updateJob(id, job);
        return ResponseEntity.ok(
                new ApiResponse<>("Job Updated", LocalDateTime.now(), updated));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> deleteJob(@PathVariable Long id){
        service.deleteJob(id);
        return ResponseEntity.ok(
                new ApiResponse<>("Job Deleted", LocalDateTime.now(), "Deleted successfully"));

    }


}
