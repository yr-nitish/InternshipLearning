package com.exampleateffigo.one_to_many_application1.controller;

import com.exampleateffigo.one_to_many_application1.entity.Student;
import com.exampleateffigo.one_to_many_application1.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<Student> getAllStudents()
    {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Optional<Student> getthisstudent(@PathVariable int id)
    {
        return studentService.getStudentById(id);
    }

    @PostMapping
    public Student addNewStudent(@RequestBody Student student)
    {
        return studentService.addStudent(student);
    }
}
