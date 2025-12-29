package org.example.repository;

import org.example.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository
{
    private List<Student> students = new ArrayList<>();

    public Student save(Student student)
    {
        students.add(student);
        return student;
    }
    public List<Student> findAll()
    {
        return students;
    }
    public Student findById(int id)
    {
        return students.stream()
                .filter(s->s.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public Student update(int id, Student updateData) {
        Student existing = findById(id);
        if (existing != null) {
            existing.setName(updateData.getName());
            existing.setCourse(updateData.getCourse());
            return existing;
        }
        return null;
    }
    public boolean delete(int id)
    {
        return students.removeIf(s -> s.getId() ==id);
    }

}
