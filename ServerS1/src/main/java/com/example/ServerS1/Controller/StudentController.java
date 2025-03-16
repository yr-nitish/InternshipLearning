package com.example.ServerS1.Controller;

import com.example.ServerS1.Entity.Student;
import com.example.ServerS1.Service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
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
        log.info("Fetching user with ID {} from DB.", id);
        return studentService.getStudentById(id);
    }

    @DeleteMapping("/clear-all")
    public String clearCache(){
        studentService.clearCache();
        return "Cache cleared";
    }

    @GetMapping("/{id}/isCached")
    public boolean isUserCached(@PathVariable String id) {
        boolean cached = studentService.isUserInCache(id);
        log.info("User with ID {} is cached: {}", id, cached);
        return cached;
    }

    @GetMapping("/cache-data")
    public ResponseEntity<Map<String, Object>> getCachedData() {
        Map<String, Object> cachedData = studentService.getCachedData();
        return ResponseEntity.ok(cachedData);
    }
}
