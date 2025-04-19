package com.example.demo.Auth;

import com.example.demo.Models.User;
import com.example.demo.Repositories.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:3000")
public class AuthController {

    private final UserRepository userRepository;

    public AuthController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        List<User> existing = userRepository.findAll();
        boolean emailExists = existing.stream()
                .anyMatch(u -> u.getEmail().equalsIgnoreCase(user.getEmail()));

        if (emailExists) {
            return "User with this email already exists";
        }

        userRepository.save(user);
        return "Registration successful";
    }

    @PostMapping("/login")
    public Optional<User> login(@RequestBody User user) {
        Optional<User> foundUser = userRepository.findAll().stream()
                .filter(u -> u.getEmail().equalsIgnoreCase(user.getEmail()) && u.getPassword().equals(user.getPassword()))
                .findFirst();

        return foundUser;
    }
}
