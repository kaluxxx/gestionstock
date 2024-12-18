package com.webtechlabs.gestionstock.controller;

import com.webtechlabs.gestionstock.dto.UserDto;
import com.webtechlabs.gestionstock.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private UserService userService;

    @PostMapping("/register")
    public void registerUser(@RequestBody UserDto userDto) {
        userService.register(userDto);
    }
}
