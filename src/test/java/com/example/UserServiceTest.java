package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserServiceTest {

    @Test
    public void testCreateUser() {
        UserService userService = new UserService();
        User user = userService.createUser("John Doe", "john.doe@example.com");

        assertNotNull(user);
        assertEquals("John Doe", user.getName());
        assertEquals("john.doe@example.com", user.getEmail());
    }

    @Test
    public void testGetUserById() {
        UserService userService = new UserService();
        User createdUser = userService.createUser("Jane Doe", "jane.doe@example.com");
        
        User fetchedUser = userService.getUserById(createdUser.getId());
        assertNotNull(fetchedUser);
        assertEquals(createdUser.getId(), fetchedUser.getId());
    }

    @Test
    public void testGetAllUsers() {
        UserService userService = new UserService();
        userService.createUser("Alice", "alice@example.com");
        userService.createUser("Bob", "bob@example.com");

        assertEquals(2, userService.getAllUsers().size());
    }
}
