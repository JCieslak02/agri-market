package com.jcieslak.agrimarket.service;

import com.jcieslak.agrimarket.exception.EmailIsTakenException;
import com.jcieslak.agrimarket.mapper.UserMapper;
import com.jcieslak.agrimarket.model.User;
import com.jcieslak.agrimarket.payload.request.AuthenticateRequest;
import com.jcieslak.agrimarket.payload.request.RegisterRequest;
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

    public void register(RegisterRequest registerRequest){
        if(userRepository.existsByEmail(registerRequest.email())){
            throw new EmailIsTakenException(registerRequest.email());
        }

        User user = UserMapper.MAPPER.registerToEntity(registerRequest);
        user.setPassword(encoder.encode(registerRequest.password()));
        user.setCreatedAt(LocalDateTime.now());

        userRepository.save(user);
    }

    public String authenticate(AuthenticateRequest authenticateRequest){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticateRequest.email(), authenticateRequest.password()));
        return jwtService.generateToken(authentication);
    }
}
