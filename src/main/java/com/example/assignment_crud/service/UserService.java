package com.example.assignment_crud.service;

import com.example.assignment_crud.entity.User;
import com.example.assignment_crud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public String saveUser(User user) {
        return userRepository.saveUser(user);
    }

    public User getUser(String userId) throws ExecutionException, InterruptedException {
        return userRepository.getUser(userId);
    }

    public String updateUser(User user) {
        return userRepository.updateUser(user);
    }

    public String deleteUser(String userId) {
        return userRepository.deleteUser(userId);
    }

    public Iterable<User> getAllUsers() throws ExecutionException, InterruptedException {
        return userRepository.getAllUsers();
    }
}
