package com.example.ServerS1.Controller;

import com.example.ServerS1.Entity.StudentSummary;
import com.example.ServerS1.Service.StudentSummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentSummaryController {

    @Autowired
    private StudentSummaryService studentSummaryService;

    @GetMapping("/language/{lang}")
    public ResponseEntity<List<StudentSummary>> getStudentByLanguage(@PathVariable String lang){
        return ResponseEntity.ok(studentSummaryService.getStudentByLanguage(lang));
    }
}
