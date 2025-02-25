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

    private static String url="http://localhost:8081/students/get-all";

    public List<StudentDTO> fetchAllStudents(){
        ResponseEntity<StudentDTO[]> response = restTemplate.getForEntity(url, StudentDTO[].class);

        System.out.println("Raw Response: " + response);
        System.out.println("Body: " + Arrays.toString(response.getBody()));

        return Arrays.asList(response.getBody());
    }
}
