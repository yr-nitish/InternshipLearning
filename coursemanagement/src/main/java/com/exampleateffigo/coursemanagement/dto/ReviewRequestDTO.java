package com.exampleateffigo.coursemanagement.dto;

import lombok.Data;

@Data
public class ReviewRequestDTO {
    private Long userId;
    private Long courseId;
    private int rating;
    private String comment;
}
