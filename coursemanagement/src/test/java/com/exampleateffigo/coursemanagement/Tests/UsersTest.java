package com.exampleateffigo.coursemanagement.Tests;

import com.exampleateffigo.coursemanagement.dto.UserResponseDTO;
import com.exampleateffigo.coursemanagement.service.UsersService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.springframework.test.util.AssertionErrors.assertEquals;

@SpringBootTest
public class UsersTest {

    @Autowired
    private UsersService usersService;

    @Test
    void testGetUserById() {
        System.out.println("Unit Test:");
        UserResponseDTO result = usersService.getUserById(2);

        assertEquals("User name should match", "nitish", result.getUserName());
        System.out.println("Found record for Id 2: " + result);
    }
}
