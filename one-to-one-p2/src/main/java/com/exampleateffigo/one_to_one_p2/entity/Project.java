package com.exampleateffigo.one_to_one_p2.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
@Table(name="project_table")
public class Project {

    @Id
    private int projectId;
    private String projectTitle;
    private String projectDomain;

    @OneToOne
    @JoinColumn(name="student_id")
    @JsonBackReference
    private Student student;

    public int getProjectId() {
        return projectId;
    }

    public String getProjectTitle() {
        return projectTitle;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public void setProjectTitle(String projectTitle) {
        this.projectTitle = projectTitle;
    }

    public void setProjectDomain(String projectDomain) {
        this.projectDomain = projectDomain;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getProjectDomain() {
        return projectDomain;
    }

    public Student getStudent() {
        return student;
    }

    public Project() {
    }

    public Project(int projectId, String projectTitle, String projectDomain, Student student) {
        this.projectId = projectId;
        this.projectTitle = projectTitle;
        this.projectDomain = projectDomain;
        this.student = student;
    }
}
