package com.example.OTTCRUD.repository;

import com.example.OTTCRUD.entity.OttPlatform;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OttRepository extends JpaRepository<OttPlatform, Long>
{
}
