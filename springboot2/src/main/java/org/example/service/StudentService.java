package org.example.service;

import org.example.model.Student;
import org.example.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService
{
    @Autowired
    private StudentRepository repo;

    public Student addStudent(Student student)
    {
        return repo.save(student);
    }

    public List<Student> getAllStudents()
    {
        return repo.findAll();
    }

    public Student getStudentById(int id)
    {
        return repo.findById(id);
    }
    public Student updateStudent(int id, Student student)
    {
        student.setId(id);
        return repo.update(id, student);
    }

    public boolean deleteStudent(int id)
    {
        return repo.delete(id);
    }
}
