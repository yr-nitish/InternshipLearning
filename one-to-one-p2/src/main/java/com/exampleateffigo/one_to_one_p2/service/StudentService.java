package com.exampleateffigo.one_to_one_p2.service;

import com.exampleateffigo.one_to_one_p2.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    List<Student> getAllStudents();
    Optional<Student> getStudentById(int id);
    Student addStudent(Student student);
    Student updateStudent(int id, Student student);
    void deleteStudent(int id);
}
