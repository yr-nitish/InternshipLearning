package com.example.ServerS1.Service;

import com.example.ServerS1.Entity.StudentSummaryViewEntity;
import com.example.ServerS1.Repository.StudentSummaryViewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentSummaryService {

    @Autowired
    private StudentSummaryViewRepository studentSummaryRepository;

    public List<StudentSummaryViewEntity> getStudentByLanguage(String language)
    {
        return studentSummaryRepository.findByLanguage(language);
    }


}
