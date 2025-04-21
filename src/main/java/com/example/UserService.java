package com.example;

import java.util.HashMap;
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
    public Map<Integer, User> getAllUsers() {
        return userRepository;
    }
}
