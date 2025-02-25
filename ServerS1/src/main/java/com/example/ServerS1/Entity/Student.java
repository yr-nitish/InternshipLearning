package com.example.ServerS1.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
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
