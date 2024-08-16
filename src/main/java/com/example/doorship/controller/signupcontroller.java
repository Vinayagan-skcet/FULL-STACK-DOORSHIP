package com.example.doorship.controller;

import lombok.AllArgsConstructor;

import com.example.doorship.dto.LoginDto;
import com.example.doorship.dto.signupdto;
import com.example.doorship.entity.signup;
import com.example.doorship.dto.signupdto;

import com.example.doorship.service.signupservice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/doorship")
public class signupcontroller {

    private final signupservice service;

    // Build Add signup REST API
    @PostMapping("/signup")
    public ResponseEntity<signupdto> createSignup(@RequestBody signupdto signupdto) {
        signupdto savedSignup = service.createSignup(signupdto);
        return new ResponseEntity<>(savedSignup, HttpStatus.CREATED);
    }

    // Build Get signup By ID REST API
    @GetMapping("{id}")
    public ResponseEntity<signupdto> getSignupById(@PathVariable("id") Long signupId) {
        signupdto signupdto = service.getSignupById(signupId);
        return ResponseEntity.ok(signupdto);
    }

    // Build Get All signups REST API
    @GetMapping
    public ResponseEntity<List<signupdto>> getAllSignups() {
        List<signupdto> signups = service.getAllSignup();
        return ResponseEntity.ok(signups);
    }

    // Build Update signup REST API
    @PutMapping("{id}")
    public ResponseEntity<signupdto> updateSignup(@PathVariable("id") Long signupId, @RequestBody signupdto updatedSignup) {
        signupdto signupdto = service.updateSignup(signupId, updatedSignup);
        return ResponseEntity.ok(signupdto);
    }

    // Build Delete signup REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteSignup(@PathVariable("id") Long signupId) {
        service.deleteSignup(signupId);
        return ResponseEntity.ok("Signup deleted successfully!");
    }
    
    @PostMapping("/signin")
    public ResponseEntity<?> signin(@RequestBody LoginDto loginDto) {
        signup user = service.authenticateUser(loginDto);
        if (user != null) {
            // Authentication successful
            return ResponseEntity.ok(user);
        } else {
            // Authentication failed
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }
  
}
