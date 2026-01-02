package com.example.mappingdemo.controller;

import com.example.mappingdemo.entity.User;
import com.example.mappingdemo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepository;

    @PostMapping
    public User saveUser(@RequestBody User user)
    {
        return userRepository.save(user);
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id)
    {
        return userRepository.findById(id).orElseThrow();
    }
}
