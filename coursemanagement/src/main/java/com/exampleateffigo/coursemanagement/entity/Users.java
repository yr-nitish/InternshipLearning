package com.exampleateffigo.coursemanagement.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class Users
{
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Id
    private long userId;

    private String userName;
    private String userEmail;

    @OneToMany(mappedBy = "users", cascade = CascadeType.ALL)
//    @JsonIgnore
    private List<Orders> ordersList= new ArrayList<>();

    @OneToMany(mappedBy = "users", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Reviews> reviewsList = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "enrollments",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    @JsonIgnore
    private List<Courses> enrolledCourses= new ArrayList<>();
}
