package com.technicallab.springbootunittest.integrationtest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/users/{id}/register")
    public User register(
            @PathVariable("id") Integer userId,
            @Valid @RequestBody User user,
            @RequestParam("sendWelcomeEmail") boolean sendWelcomeEmail) {

        User newUser = new User(user.getId(), user.getName());

        return userRepository.save(newUser);

    }

    @GetMapping("/users")
    public List<User> listAllUsers() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }
}
