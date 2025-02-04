package com.exampleateffigo.coursemanagement.dto;

import lombok.Data;

@Data
public class CourseResponseDTO {
    private long courseId;
    private String courseName;
    private double coursePrice;
    private String courseCategory;
}
