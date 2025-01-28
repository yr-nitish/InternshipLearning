package com.exampleateffigo.one_to_one_p2.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
@Table(name="student_table")
public class Student {

    @Id
    private int studentId;
    private String studentName;
    private String studentLocation;

    @OneToOne(mappedBy ="student", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Project project;

    public Student() {
    }

    public Student(int studentId, String studentName, String studentLocation, Project project) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentLocation = studentLocation;
        this.project = project;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentLocation() {
        return studentLocation;
    }

    public void setStudentLocation(String studentLocation) {
        this.studentLocation = studentLocation;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }


}
