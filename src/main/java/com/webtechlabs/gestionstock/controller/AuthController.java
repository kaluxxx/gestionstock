package com.webtechlabs.gestionstock.controller;

import com.webtechlabs.gestionstock.dto.AuthRequestDto;
import com.webtechlabs.gestionstock.dto.AuthResponseDto;
import com.webtechlabs.gestionstock.dto.UserCreateDto;
import com.webtechlabs.gestionstock.service.AuthService;
import com.webtechlabs.gestionstock.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;
    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<Void> registerUser(@RequestBody @Valid UserCreateDto userCreateDto) {
        userService.create(userCreateDto);
        return ResponseEntity.status(201).build();
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDto> authenticateUser(@RequestBody @Valid AuthRequestDto authRequestDto) {
        AuthResponseDto authResponseDto = authService.login(authRequestDto);
        return ResponseEntity.ok(authResponseDto);
    }
}
