package com.example;

import java.util.ArrayList;
import java.util.List;

public class UserService {

    private List<User> users = new ArrayList<>();

    public User addUser(String name, String email) {
        User user = new User(name, email);
        users.add(user);
        return user;
    }

    public List<User> getAllUsers() {
        return users;
    }

    public User getUserByEmail(String email) {
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        return null;
    }

    public boolean deleteUser(String email) {
        User user = getUserByEmail(email);
        if (user != null) {
            users.remove(user);
            return true;
        }
        return false;
    }
}
