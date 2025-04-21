package com.example;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    private List<User> users = new ArrayList<>();

    // Add a new user
    public boolean addUser(User user) {
        for (User existingUser : users) {
            if (existingUser.getUsername().equals(user.getUsername())) {
                return false;  // Username already exists
            }
        }
        users.add(user);
        return true;
    }

    // Get user by username
    public User getUser(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;  // User not found
    }

    // Update user details
    public boolean updateUser(String username, User updatedUser) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUsername().equals(username)) {
                users.set(i, updatedUser);
                return true;
            }
        }
        return false;  // User not found
    }

    // Delete user
    public boolean deleteUser(String username) {
        return users.removeIf(user -> user.getUsername().equals(username));
    }
}
