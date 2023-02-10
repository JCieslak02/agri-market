package com.jcieslak.agrimarket.service;

import com.jcieslak.agrimarket.model.User;
import com.jcieslak.agrimarket.payload.LoginRequest;
import com.jcieslak.agrimarket.payload.RegisterRequest;
import com.jcieslak.agrimarket.repository.UserRepository;
import com.jcieslak.agrimarket.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    // I'll add validation later, for now it's just for testing purposes
    public void register(RegisterRequest registerRequest){
        User user = new User();
        user.setEmail(registerRequest.email());
        user.setRole(registerRequest.userRole());
        user.setFirstName(registerRequest.firstName());
        user.setPassword(encoder.encode(registerRequest.password()));
        user.setCreatedAt(LocalDateTime.now());

        userRepository.save(user);
    }

    public String authenticate(LoginRequest loginRequest){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.email(), loginRequest.password()));
        return jwtService.generateToken(authentication);
    }
}
