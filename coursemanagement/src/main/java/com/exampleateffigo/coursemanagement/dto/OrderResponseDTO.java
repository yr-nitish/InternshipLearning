package com.exampleateffigo.coursemanagement.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrderResponseDTO {
    private long orderId;
    private LocalDateTime createdAt;
    private long userId;
    private long courseId;
}
