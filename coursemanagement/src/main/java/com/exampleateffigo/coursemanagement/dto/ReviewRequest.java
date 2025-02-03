package com.exampleateffigo.coursemanagement.dto;

import lombok.Data;

@Data
public class ReviewRequest {
    private Long userId;
    private Long courseId;
    private int rating;
    private String comment;
}
