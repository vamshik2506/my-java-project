package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class UserServiceTest {

    @Test
    public void testAddUser() {
        UserService userService = new UserService();
        User user = userService.addUser("John Doe", "john@example.com");
        assertNotNull(user);
        assertEquals("John Doe", user.getName());
        assertEquals("john@example.com", user.getEmail());
    }

    @Test
    public void testGetAllUsers() {
        UserService userService = new UserService();
        userService.addUser("John Doe", "john@example.com");
        List<User> users = userService.getAllUsers();
        assertEquals(1, users.size());
    }

    @Test
    public void testGetUserByEmail() {
        UserService userService = new UserService();
        userService.addUser("John Doe", "john@example.com");
        User user = userService.getUserByEmail("john@example.com");
        assertNotNull(user);
        assertEquals("John Doe", user.getName());
    }

    @Test
    public void testDeleteUser() {
        UserService userService = new UserService();
        userService.addUser("John Doe", "john@example.com");
        boolean isDeleted = userService.deleteUser("john@example.com");
        assertTrue(isDeleted);

        // Verify user is deleted
        User user = userService.getUserByEmail("john@example.com");
        assertNull(user);
    }
}
