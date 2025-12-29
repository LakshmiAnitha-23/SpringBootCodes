package com.example.ResponseEntity.repository;

import com.example.ResponseEntity.entity.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalRepository extends JpaRepository<Hospital, Long>
{
}
