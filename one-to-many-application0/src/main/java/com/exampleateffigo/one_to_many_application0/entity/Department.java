package com.exampleateffigo.one_to_many_application0.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "department_otm")
public class Department {

    @Id
    private long departmentId;
    private String departmentName;

    @OneToMany
    private List<Student> studentList = new ArrayList<>();
}
