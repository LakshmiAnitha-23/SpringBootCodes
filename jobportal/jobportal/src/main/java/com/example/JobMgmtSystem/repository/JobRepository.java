package com.example.JobMgmtSystem.repository;

import com.example.JobMgmtSystem.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobRepository extends JpaRepository<Job, Long>
{
    List<Job> findByCompany(String company);
}
