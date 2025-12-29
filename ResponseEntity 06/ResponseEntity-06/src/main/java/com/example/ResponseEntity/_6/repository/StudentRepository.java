package com.example.ResponseEntity._6.repository;

import com.example.ResponseEntity._6.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long>
{
    List<Student> findByName(String name);
    List<Student> findByCourse(String course);
    List<Student> findByMarksGreaterThan(int marks);
}

