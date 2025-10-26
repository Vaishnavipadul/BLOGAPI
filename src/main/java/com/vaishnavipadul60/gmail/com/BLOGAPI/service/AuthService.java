package com.vaishnavipadul60.gmail.com.BLOGAPI.service;

import com.vaishnavipadul60.gmail.com.BLOGAPI.dto.AuthRequest;
import com.vaishnavipadul60.gmail.com.BLOGAPI.dto.AuthResponse;
import com.vaishnavipadul60.gmail.com.BLOGAPI.entity.User;

public interface AuthService {
    AuthResponse login(AuthRequest request);
    User register(String username, String email, String password);
}
