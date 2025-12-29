package org.example.service;

import org.example.model.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentService
{
    public Student getStudent()
    {
        return new Student(1, "Anitha", "Java Full Stack");
    }
}
