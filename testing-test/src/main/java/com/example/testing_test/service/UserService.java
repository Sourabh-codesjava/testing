package com.example.testing_test.service;

import com.example.testing_test.model.User;
import com.example.testing_test.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    public User register(User user){
        Optional<User> existingUser = userRepo.findByEmail(user.getEmail());
        if(existingUser.isPresent()){
            throw new RuntimeException("Email already exists");
        }
        return userRepo.save(user);
    }
}
