package com.exampleateffigo.coursemanagement.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "reviews")
public class Reviews {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long reviewId;

    private LocalDateTime createdAt = LocalDateTime.now();

    private int rating;

    @Column(length = 1000)
    private String comment;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private Users users;

    @ManyToOne
    @JoinColumn(name = "course_id")
    @JsonBackReference
    private Courses courses;
}
