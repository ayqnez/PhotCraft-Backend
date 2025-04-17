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
    public String register(
            @RequestParam String username,
            @RequestParam String email,
            @RequestParam String password,
            @RequestParam String role,
            @RequestParam(required = false) String specialization
    ) {
        List<User> existing = userRepository.findAll();
        boolean emailExists = existing.stream().anyMatch(u -> u.getEmail().equalsIgnoreCase(email));

        if (emailExists) {
            return "User with this email already exists";
        }

        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);
        user.setRole(role);
        user.setSpecialization(specialization);

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
