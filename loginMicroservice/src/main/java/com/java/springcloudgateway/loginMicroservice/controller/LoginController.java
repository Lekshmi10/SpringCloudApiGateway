package com.java.springcloudgateway.loginMicroservice.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.java.springcloudgateway.loginMicroservice.authentication.JwtUtil;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController

public class LoginController {

    @Autowired
    private JwtUtil jwtUtil;
    private static final String SECRET_KEY = "jwtspringcloud";
    @PostMapping("/auth/login")
    public ResponseEntity<?> login(@RequestParam String username, @RequestParam String password) {
        // Validate user credentials (dummy validation here)
        if ("user".equals(username) && "pass".equals(password)) {
            String token = Jwts.builder()
                    .setSubject(username)
                    .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                    .compact();
            return ResponseEntity.ok().body("{\"token\":\"" + token + "\"}");
        } else {
            return ResponseEntity.status(401).body("Invalid credentials");
        }
    }
}
