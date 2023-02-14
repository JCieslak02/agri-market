package com.jcieslak.agrimarket.controller;

import com.jcieslak.agrimarket.payload.request.AuthenticateRequest;
import com.jcieslak.agrimarket.payload.request.RegisterRequest;
import com.jcieslak.agrimarket.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody @Valid RegisterRequest registerRequest){
        authService.register(registerRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/authenticate")
    public ResponseEntity<String> authenticate(@RequestBody @Valid AuthenticateRequest authenticateRequest){
        String token = authService.authenticate(authenticateRequest);
        return new ResponseEntity<>(token, HttpStatus.OK);
    }
}
