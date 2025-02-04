package com.exampleateffigo.coursemanagement.dto;

import lombok.Data;

@Data
public class UserResponseDTO {
    private long userId;
    private String userName;
    private String userEmail;
}
