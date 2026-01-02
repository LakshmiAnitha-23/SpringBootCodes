package com.example.mappingdemo.controller;

import com.example.mappingdemo.entity.Employee;
import com.example.mappingdemo.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController
{
    private final EmployeeRepository employeeRepository;

    @PostMapping
    public Employee saveEmployee(@RequestBody Employee employee)
    {
        return employeeRepository.save(employee);
    }

    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable Long id)
    {
        return employeeRepository.findById(id).orElseThrow();
    }
}
