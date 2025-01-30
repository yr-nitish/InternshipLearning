package com.exampleateffigo.many_to_one_application0.services;

import com.exampleateffigo.many_to_one_application0.entity.Student;
import com.exampleateffigo.many_to_one_application0.entity.Department;
import com.exampleateffigo.many_to_one_application0.repository.StudentRepository;
import com.exampleateffigo.many_to_one_application0.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    public Student addStudent(Student student) {
        Department department = departmentRepository.findById(student.getDepartment().getDepartmentId())
                .orElseThrow(() -> new RuntimeException("Department not found!"));

        student.setDepartment(department);
        return studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
    }

    public Student updateStudent(Long id, Student studentDetails) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));

        student.setStudentName(studentDetails.getStudentName());

//        // If department ID is changed, fetch the new department
//        if (studentDetails.getDepartment() != null && studentDetails.getDepartment().getDepartmentId() != null) {
//            Department department = departmentRepository.findById(studentDetails.getDepartment().getDepartmentId())
//                    .orElseThrow(() -> new RuntimeException("Department not found!"));
//            student.setDepartment(department);
//        }

        return studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));

        studentRepository.delete(student);
    }
}
