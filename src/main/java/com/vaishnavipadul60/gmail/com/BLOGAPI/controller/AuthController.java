package com.vaishnavipadul60.gmail.com.BLOGAPI.controller;

import com.vaishnavipadul60.gmail.com.BLOGAPI.dto.AuthRequest;
import com.vaishnavipadul60.gmail.com.BLOGAPI.dto.AuthResponse;
import com.vaishnavipadul60.gmail.com.BLOGAPI.entity.User;
import com.vaishnavipadul60.gmail.com.BLOGAPI.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) { this.authService = authService; }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Map<String,String> body){
        String username = body.get("username");
        String email = body.get("email");
        String password = body.get("password");
        User u = authService.register(username,email,password);
        return ResponseEntity.ok(Map.of("id", u.getId(), "username", u.getUsername(), "email", u.getEmail()));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request){
        AuthResponse resp = authService.login(request);
        return ResponseEntity.ok(resp);
    }
}
