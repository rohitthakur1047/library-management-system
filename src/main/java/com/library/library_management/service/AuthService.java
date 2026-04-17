package com.library.library_management.service;


import com.library.library_management.entity.User;
import com.library.library_management.repository.UserRepository;
import com.library.library_management.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository repo;

    @Autowired
    private JwtUtil jwtUtil;

    public String register(User user) {
        repo.save(user);
        return "User Registered";
    }

    public String login(String email, String password) {
        User user = repo.findByEmail(email).orElseThrow();

        if (!user.getPassword().equals(password)) {
            throw new RuntimeException("Invalid password");
        }

        return jwtUtil.generateToken(email);
    }
}