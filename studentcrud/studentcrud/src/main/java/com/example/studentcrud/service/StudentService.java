package com.example.studentcrud.service;

import com.example.studentcrud.entity.Student;

import java.util.List;

public interface StudentService
{
    Student saveStudent(Student student);

    List<Student> getAllStudents();

    Student getStudentById(Long id);

    Student updateStudent(Long id, Student student);

    void deleteStudent(Long id);
}
