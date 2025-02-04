package com.exampleateffigo.coursemanagement.dto;

import lombok.Data;

@Data
public class CourseRequestDTO {
    private String courseName;
    private double coursePrice;
    private String courseCategory;
}
