package com.exampleateffigo.one_to_many_application0.controller;

import com.exampleateffigo.one_to_many_application0.entity.Department;
import com.exampleateffigo.one_to_many_application0.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/departmentotm")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping
    public List<Department> getAllDepartments()
    {
        return departmentService.getAllDepartments();
    }

    @GetMapping("/{id}")
    public Optional<Department> getDepartment(@PathVariable("id") long id)
    {
        return departmentService.getDepartmentById(id);
    }

    @PostMapping
    public Department addDepartment(@RequestBody Department department)
    {
        return departmentService.addDepartment(department);
    }
}
