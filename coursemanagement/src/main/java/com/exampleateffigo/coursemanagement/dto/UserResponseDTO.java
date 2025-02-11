package com.exampleateffigo.coursemanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserResponseDTO {
    private long userId;
    private String userName;
    private String userEmail;
}
