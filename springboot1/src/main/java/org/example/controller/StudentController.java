package org.example.controller;

import org.example.model.Student;
import org.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController
{
    @Autowired
    private StudentService studentService;

    @GetMapping("/student")
    public Student getStudentDetails()
    {
        return studentService.getStudent();
    }
}
