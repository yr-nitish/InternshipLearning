package com.exampleateffigo.many_to_one_application0.entity;

import com.exampleateffigo.many_to_one_application0.entity.Department;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long studentId;

    private String studentName;

    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    @JsonIgnoreProperties("hibernateLazyInitializer")
    private Department department;
}
