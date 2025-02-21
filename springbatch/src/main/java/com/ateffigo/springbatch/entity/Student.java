package com.ateffigo.springbatch.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "student_batch")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id1;

    private String id;
    private String name;
    private String language;
    @Column(columnDefinition = "TEXT")
    private String bio;
    private double version;
}
