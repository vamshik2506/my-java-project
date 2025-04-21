package com.example;

import java.util.List;
import java.util.ArrayList;

public class UserService {

    private List<User> users = new ArrayList<>();

    // Add a new user
    public User addUser(String name, String email) {
        User user = new User(name, email);
        users.add(user);
        return user;
    }

    // Get all users
    public List<User> getAllUsers() {
        return users;
    }

    // Find user by email
    public User getUserByEmail(String email) {
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        return null;
    }

    // Delete a user
    public boolean deleteUser(String email) {
        User user = getUserByEmail(email);
        if (user != null) {
            users.remove(user);
            return true;
        }
        return false;
    }
}
