package com.example.EmployeeCRUD.repository;

import com.example.EmployeeCRUD.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long>
{
}
