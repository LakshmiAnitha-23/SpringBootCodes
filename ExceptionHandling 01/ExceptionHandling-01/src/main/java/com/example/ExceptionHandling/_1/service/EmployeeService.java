package com.example.ExceptionHandling._1.service;

import com.example.ExceptionHandling._1.entity.Employee;
import com.example.ExceptionHandling._1.exception.EmployeeNotFoundException;
import com.example.ExceptionHandling._1.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService
{
    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee getEmployeeById(Long id)
    {
        return employeeRepository.findById(id)
                .orElseThrow(() ->
                        new EmployeeNotFoundException(
                                "Employee not found with id: " + id));
    }
}
