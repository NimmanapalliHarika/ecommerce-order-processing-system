package com.e_comm.authservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.e_comm.authservice.dto.request.LoginRequest;
import com.e_comm.authservice.dto.request.UserRequest;
import com.e_comm.authservice.dto.response.AuthenticationResponse;
import com.e_comm.authservice.dto.response.UserResponse;
import com.e_comm.authservice.service.AuthService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;
    
    public AuthController(AuthService authService) {
    	this.authService=authService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(
            @Valid @RequestBody UserRequest request) {

        return ResponseEntity.ok(
                authService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(
            @RequestBody LoginRequest request)
            throws Exception {

        return ResponseEntity.ok(
                authService.login(request));
    }

}