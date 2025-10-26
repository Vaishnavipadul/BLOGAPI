package com.vaishnavipadul60.gmail.com.BLOGAPI.service;

import com.vaishnavipadul60.gmail.com.BLOGAPI.dto.AuthRequest;
import com.vaishnavipadul60.gmail.com.BLOGAPI.dto.AuthResponse;
import com.vaishnavipadul60.gmail.com.BLOGAPI.entity.User;
import com.vaishnavipadul60.gmail.com.BLOGAPI.repository.UserRepository;
import com.vaishnavipadul60.gmail.com.BLOGAPI.security.JwtTokenUtil;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenUtil jwtTokenUtil;

    public AuthServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtTokenUtil jwtTokenUtil) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @Override
    public AuthResponse login(AuthRequest request) {
        User user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new RuntimeException("Invalid username or password"));
        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid username or password");
        }
        String token = jwtTokenUtil.generateToken(user.getUsername());
        return new AuthResponse(token, user.getUsername());
    }

    @Override
    public User register(String username, String email, String password) {
        if (userRepository.existsByUsername(username)) {
            throw new RuntimeException("Username already taken");
        }
        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));
        user.setRole("USER");
        return userRepository.save(user);
    }
}
