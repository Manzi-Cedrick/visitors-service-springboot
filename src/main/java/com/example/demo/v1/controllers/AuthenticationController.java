package com.example.demo.v1.controllers;

import com.example.demo.v1.dtos.SignInDTO;
import com.example.demo.v1.dtos.UserDTO;
import com.example.demo.v1.repositories.IUserRepository;
import com.example.demo.v1.services.impl.AuthenticationService;
import com.example.demo.v1.utils.JWTAuthenticationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.management.relation.RoleNotFoundException;

@RestController
@RequestMapping("/api/v1/auth")
@Slf4j
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService service;

    @PostMapping("/register")
    public ResponseEntity<JWTAuthenticationResponse> register(
            @RequestBody UserDTO userDTO
    ) throws RoleNotFoundException {
        return ResponseEntity.ok(service.register(userDTO));
    }
    @PostMapping("/authenticate")
    public ResponseEntity<JWTAuthenticationResponse> authenticate(
            @RequestBody SignInDTO request
    ) {
        return ResponseEntity.ok(service.authenticate(request));
    }
}
