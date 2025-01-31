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
@Table(name = "student_otm")
public class Student {

    @Id
    private int studentId;
    private String studentName;
    private String studentEmail;
    private String studentGender;
}
