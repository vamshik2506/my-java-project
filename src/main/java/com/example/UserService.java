package com.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserService {
    private Map<Integer, User> userRepository = new HashMap<>();
    private int idCounter = 1;

    // Create a new user
    public User createUser(String name, String email) {
        User user = new User(idCounter++, name, email);
        userRepository.put(user.getId(), user);
        return user;
    }

    // Get a user by ID
    public User getUserById(int id) {
        return userRepository.get(id);
    }

    // Get all users
    public List<User> getAllUsers() {
        return new ArrayList<>(userRepository.values());
    }
    
    // Get a user by email
    public User getUserByEmail(String email) {
        return userRepository.values().stream()
            .filter(user -> user.getEmail().equals(email))
            .findFirst()
            .orElse(null);
    }

    // Delete a user
    public boolean deleteUser(String email) {
        User user = getUserByEmail(email);
        if (user != null) {
            userRepository.remove(user.getId());
            return true;
        }
        return false;
    }
}
