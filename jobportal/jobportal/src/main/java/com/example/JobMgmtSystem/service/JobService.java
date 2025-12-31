package com.example.JobMgmtSystem.service;

import com.example.JobMgmtSystem.entity.Job;
import com.example.JobMgmtSystem.exception.JobNotFoundException;
import com.example.JobMgmtSystem.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService
{
    @Autowired
    private JobRepository repository;

    public Job createJob(Job job)
    {
        return repository.save(job);
    }

    public Job getJobById(Long id)
    {
        return repository.findById(id)
                .orElseThrow(() -> new JobNotFoundException("job not found with id: " +id));
    }

    public List<Job> getJobsByCompany(String company)
    {
        return repository.findByCompany(company);
    }

    public Job updateJob(long id, Job job)
    {
        Job existing = getJobById(id);
        existing.setTitle(job.getTitle());
        existing.setCompany(job.getCompany());
        existing.setLocation(job.getLocation());
        existing.setSalary(job.getSalary());
        return repository.save(existing);
    }

    public void deleteJob(Long id)
    {
        Job job = getJobById(id);
        repository.delete(job);
    }
}
