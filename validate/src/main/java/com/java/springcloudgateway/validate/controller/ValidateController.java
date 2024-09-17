package com.java.springcloudgateway.validate.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class ValidateController {

    @GetMapping("/validate")
    public ResponseEntity<String> validateUser(@RequestHeader("Authorization") String token) {
        String jwtToken = token.replace("Bearer ", "");
        
        
        if (jwtToken.equals(jwtToken)) { // Replace with your token validation logic
            return ResponseEntity.ok("HII");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Token");
        }
    }
}
