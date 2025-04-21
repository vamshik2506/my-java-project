package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class UserService {

    private List<User> users = new ArrayList<>();

    // Method to add a user
    public User addUser(String name, String email) {
        User user = new User(name, email);
        users.add(user);
        return user;
    }

    // Method to get all users
    public List<User> getAllUsers() {
        return users;
    }

    // Method to get a user by email
    public User getUserByEmail(String email) {
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        return null;
    }

    // Method to delete a user by email
    public boolean deleteUser(String email) {
        User user = getUserByEmail(email);
        if (user != null) {
            users.remove(user);
            return true;
        }
        return false;
    }

    // User class
    public static class User {
        private String name;
        private String email;

        public User(String name, String email) {
            this.name = name;
            this.email = email;
        }

        public String getName() {
            return name;
        }

        public String getEmail() {
            return email;
        }
    }

    // Test cases for the UserService
    public static class UserServiceTest {

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
}
