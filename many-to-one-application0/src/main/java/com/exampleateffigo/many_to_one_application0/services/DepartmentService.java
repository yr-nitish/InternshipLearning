package com.exampleateffigo.many_to_one_application0.services;

import com.exampleateffigo.many_to_one_application0.entity.Department;
import com.exampleateffigo.many_to_one_application0.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public Optional<Department> getDepartmentById(Long id) {
        return Optional.ofNullable(departmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Department not found with id: " + id)));
    }

    public Department addDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public Department updateDepartment(Long id, Department updatedDepartment) {
        if (departmentRepository.existsById(id)) {
            updatedDepartment.setDepartmentId(id);
            return departmentRepository.save(updatedDepartment);
        }
        return null;
    }

    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }
}
