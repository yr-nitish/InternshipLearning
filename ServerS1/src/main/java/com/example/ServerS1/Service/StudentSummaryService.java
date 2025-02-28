package com.example.ServerS1.Service;

import com.example.ServerS1.Entity.StudentSummary;
import com.example.ServerS1.Repository.StudentSummaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentSummaryService {

    @Autowired
    private StudentSummaryRepository studentSummaryRepository;

    public List<StudentSummary> getStudentByLanguage(String language)
    {
        return studentSummaryRepository.findByLanguage(language);
    }


}
