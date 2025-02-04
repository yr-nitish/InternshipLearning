package com.exampleateffigo.coursemanagement.dto;

import lombok.Data;

@Data
public class ReviewResponseDTO {
    private long reviewId;
    private Long userId;
    private Long courseId;
    private int rating;
    private String comment;
}
