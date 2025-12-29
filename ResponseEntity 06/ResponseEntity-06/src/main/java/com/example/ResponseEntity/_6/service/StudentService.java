package com.example.ResponseEntity._6.service;

import com.example.ResponseEntity._6.entity.Student;
import com.example.ResponseEntity._6.exception.StudentNotFoundException;
import com.example.ResponseEntity._6.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService
{
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository)
    {
        this.studentRepository = studentRepository;
    }

    public Student saveStudent(Student student)
    {
        return studentRepository.save(student);
    }

    public List<Student> getAllStudents()
    {
        return studentRepository.findAll();
    }
    public Student getStudentById(Long id)
    {
        return studentRepository.findById(id)
                .orElseThrow(() ->
                        new StudentNotFoundException("student not found with id: " + id));
    }

    public List<Student> getByCourse(String course)
    {
        return studentRepository.findByCourse(course);
    }

    public List<Student> getByMarks(int marks)
    {
        return studentRepository.findByMarksGreaterThan(marks);
    }

    public void deleteStudent(Long id)
    {
        if (!studentRepository.existsById(id))
        {
            throw new StudentNotFoundException("student notfound with id: " + id);
        }
        studentRepository.deleteById(id);
    }
}
