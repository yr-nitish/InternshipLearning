package com.exampleateffigo.one_to_one_p2.service;

import com.exampleateffigo.one_to_one_p2.entity.Student;
import com.exampleateffigo.one_to_one_p2.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents()
    {
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentById(int id)
    {
        return studentRepository.findById(id);
    }

    public Student addStudent(Student student)
    {
        if(student.getProject()!=null)
        {
            student.getProject().setStudent(student);
        }
        return studentRepository.save(student);
    }

    public Student updateStudent(int id, Student updatedStudent) {
        return studentRepository.findById(id).map(student -> {
            student.setStudentName(updatedStudent.getStudentName());
            student.setStudentLocation(updatedStudent.getStudentLocation());
            student.setProject(updatedStudent.getProject());
            return studentRepository.save(student);
        }).orElse(null);
    }

    public void deleteStudent(int id) {
        studentRepository.deleteById(id);
    }
}
