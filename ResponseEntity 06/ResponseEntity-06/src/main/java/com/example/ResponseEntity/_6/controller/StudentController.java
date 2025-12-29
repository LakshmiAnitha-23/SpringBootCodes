package com.example.ResponseEntity._6.controller;

import com.example.ResponseEntity._6.entity.Student;
import com.example.ResponseEntity._6.responses.ApiResponse;
import com.example.ResponseEntity._6.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController
{
    private final StudentService studentService;

    public StudentController(StudentService studentService)
    {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Student>> addStudent(@RequestBody Student student)
    {
        return ResponseEntity.ok(
                new ApiResponse<>("student createdsuccessfully",
                        studentService.saveStudent(student),
                        LocalDateTime.now())
        );
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Student>>> getAllStudents()
    {
        return ResponseEntity.ok(
                new ApiResponse<>("All students fetched",
                        studentService.getAllStudents(),
                        LocalDateTime.now())
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Student>> getStudent(@PathVariable Long id)
    {
        return ResponseEntity.ok(
                new ApiResponse<>("student found",
                        studentService.getStudentById(id),
                        LocalDateTime.now())
        );
    }

    @GetMapping("/course/{course}")
    public ResponseEntity<ApiResponse<List<Student>>> getByCourse(@PathVariable String course)
    {
        return ResponseEntity.ok(
                new ApiResponse<>("students by course",
                        studentService.getByCourse(course),
                        LocalDateTime.now())
        );
    }

    @GetMapping("/marks/{marks}")
    public ResponseEntity<ApiResponse<List<Student>>> getByMarks(@PathVariable int marks)
    {
       return ResponseEntity.ok(
               new ApiResponse<>("students with marks greater than " + marks,
                       studentService.getByMarks(marks),
                       LocalDateTime.now())
       );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> deleteStudent(@PathVariable Long id)
    {
        studentService.deleteStudent(id);
        return ResponseEntity.ok(
                new ApiResponse<>("student deleted successfully",
                        "Delete ID: " + id,
                        LocalDateTime.now())
        );
    }

}
