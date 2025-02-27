package com.example.ServerS1.Service;

import com.example.ServerS1.Entity.Student;
import com.example.ServerS1.Repository.StudentRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

import java.io.File;
import java.util.List;

@Data
@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final ObjectMapper objectMapper;

    public StudentService(StudentRepository studentRepository, ObjectMapper objectMapper) {
        this.studentRepository = studentRepository;
        this.objectMapper = objectMapper;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public List<Student> getStudentById(String id) {
        return studentRepository.findByStudentId(id);
    }



    public String uploadJsonFile() {
        try {
            StopWatch stopWatch = new StopWatch();
            stopWatch.start();

            File file = new File("src/main/resources/data.json");

            List<Student> students = objectMapper.readValue(file, new TypeReference<List<Student>>() {});

            studentRepository.saveAll(students);

            stopWatch.stop();
            long elapsedTime = stopWatch.getTotalTimeMillis(); // Get time in milliseconds

            return "Data loaded successfully in " + elapsedTime + " ms!";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error loading data: " + e.getMessage();
        }
    }

    @Scheduled(fixedRate = 5000)
    public void sayHii() {
//        System.out.println("Hii!!!");
    }

    // Run every day at 11:55 AM
    @Scheduled(cron = "0 55 11 * * ?")
    public void greet() {
        System.out.println("Have a great day, Nitish!!");
    }
}
