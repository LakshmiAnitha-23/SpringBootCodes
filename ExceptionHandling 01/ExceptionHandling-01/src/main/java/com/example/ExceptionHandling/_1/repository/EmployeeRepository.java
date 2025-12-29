package com.example.ExceptionHandling._1.repository;

import com.example.ExceptionHandling._1.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long>
{
}
