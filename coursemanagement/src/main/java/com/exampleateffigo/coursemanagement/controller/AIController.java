package com.exampleateffigo.coursemanagement.controller;

import com.exampleateffigo.coursemanagement.config.MultipartInputStreamFileResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("/api/ai")
public class AIController {

    private final RestTemplate restTemplate = new RestTemplate();

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.add("file", new MultipartInputStreamFileResource(file.getInputStream(), file.getOriginalFilename()));

        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);
        String pythonServiceUrl = "http://localhost:5000/upload";

        ResponseEntity<String> response = restTemplate.postForEntity(pythonServiceUrl, requestEntity, String.class);
        return ResponseEntity.ok(response.getBody());
    }

    @PostMapping("/ask")
    public ResponseEntity<String> askQuestion(@RequestBody Map<String, String> payload) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Map<String, String>> request = new HttpEntity<>(payload, headers);
        String pythonServiceUrl = "http://localhost:5000/ask";

        ResponseEntity<String> response = restTemplate.postForEntity(pythonServiceUrl, request, String.class);
        return ResponseEntity.ok(response.getBody());
    }
}
