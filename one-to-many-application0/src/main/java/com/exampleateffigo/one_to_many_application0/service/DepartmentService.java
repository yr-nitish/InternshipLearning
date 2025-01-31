package com.exampleateffigo.one_to_many_application0.service;

import com.exampleateffigo.one_to_many_application0.entity.Department;
import com.exampleateffigo.one_to_many_application0.entity.Student;
import com.exampleateffigo.one_to_many_application0.repository.DepartmentRepository;
import com.exampleateffigo.one_to_many_application0.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private StudentRepository studentRepository;

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public Optional<Department> getDepartmentById(long id) {
        return departmentRepository.findById(id);
    }

    public Department addDepartment(Department department) {

        List<Student> savedStudents = studentRepository.saveAll(department.getStudentList());

        // Set saved students back to the department (ensures they have valid IDs)
        department.setStudentList(savedStudents);

        // Save the department with the linked students
        return departmentRepository.save(department);
    }
}
