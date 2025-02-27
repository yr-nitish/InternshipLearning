package com.example.ServerS1.Controller;

import com.example.ServerS1.Entity.Student;
import com.example.ServerS1.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/get-all")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadJsonData() {
        String response = studentService.uploadJsonFile();
        return ResponseEntity.ok(response);
    }
    @GetMapping("/get-by-id/{id}")
    public List<Student> getById(@PathVariable String id)
    {
        return studentService.getStudentById(id);
    }
}
