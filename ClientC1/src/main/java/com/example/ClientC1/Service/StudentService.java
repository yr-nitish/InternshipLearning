package com.example.ClientC1.Service;

import com.example.ClientC1.DTO.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private RestTemplate restTemplate;

    private static final String ALL_STUDENTS_URL="http://localhost:8081/students/get-all";

    private static final String STUDENT_BY_ID_URL = "http://localhost:8081/students/get-by-id/{id}";

    public List<StudentDTO> fetchAllStudents(){
        ResponseEntity<StudentDTO[]> response = restTemplate.getForEntity(ALL_STUDENTS_URL, StudentDTO[].class);

        System.out.println("Raw Response: " + response);
        System.out.println("Body: " + Arrays.toString(response.getBody()));

        return Arrays.asList(response.getBody());
    }

    public List<StudentDTO> fetchStudentById(String id) {
        ResponseEntity<StudentDTO[]> response = restTemplate.getForEntity(STUDENT_BY_ID_URL, StudentDTO[].class, id);

        System.out.println("Raw Response: " + response);
        System.out.println("Body: " + Arrays.toString(response.getBody()));

        return Arrays.asList(response.getBody());
    }
}
