package com.Ravi.userservice.controller;

import com.Ravi.userservice.model.User;
import com.Ravi.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        try {
            User savedUser = userRepository.save(user);
            return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
        } catch (DataIntegrityViolationException e) {
            // handle the exception when a duplicate username is detected
            return new ResponseEntity<>(null, HttpStatus.CONFLICT);
        }
    }
    @GetMapping("/validateUser/{username}")
    public ResponseEntity<Boolean> validateUser(@PathVariable String username) {
        boolean userExists = userRepository.existsByUsername(username);
        return new ResponseEntity<>(userExists, HttpStatus.OK);
    }
}
