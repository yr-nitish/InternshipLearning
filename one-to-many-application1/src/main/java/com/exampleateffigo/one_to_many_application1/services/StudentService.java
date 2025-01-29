package com.exampleateffigo.one_to_many_application1.services;

import com.exampleateffigo.one_to_many_application1.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    List<Student> getAllStudents();

    Optional<Student> getStudentById(int id);

    Student addStudent(Student student);
}
