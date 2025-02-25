package com.example.ClientC1.Controller;

import com.example.ClientC1.DTO.StudentDTO;
import com.example.ClientC1.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ClientController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public List<StudentDTO> getStudents(){
        return studentService.fetchAllStudents();
    }
}
