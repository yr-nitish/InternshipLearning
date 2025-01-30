package com.exampleateffigo.many_to_one_application0.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long departmentId;

    private String departmentName;
}
