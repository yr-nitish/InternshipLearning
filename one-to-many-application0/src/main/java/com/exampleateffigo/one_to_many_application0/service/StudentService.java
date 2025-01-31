package com.exampleateffigo.one_to_many_application0.service;

import com.exampleateffigo.one_to_many_application0.entity.Student;
import com.exampleateffigo.one_to_many_application0.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;


    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentById(int id) {
        return studentRepository.findById(id);
    }


    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }
}
