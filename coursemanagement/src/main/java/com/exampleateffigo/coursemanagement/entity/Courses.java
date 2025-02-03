package com.exampleateffigo.coursemanagement.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "courses")
public class Courses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long courseId;

    private String courseName;
    private double coursePrice;
    private String courseCategory;


    @OneToMany(mappedBy = "courses", cascade =CascadeType.ALL)
    @JsonIgnore
    private List<Reviews> reviews = new ArrayList<>();

    @OneToMany(mappedBy = "courses", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Orders> orders= new ArrayList<>();

    @ManyToMany(mappedBy = "enrolledCourses")
    @JsonIgnore
    private List<Users> enrolledUsers = new ArrayList<>();
}
