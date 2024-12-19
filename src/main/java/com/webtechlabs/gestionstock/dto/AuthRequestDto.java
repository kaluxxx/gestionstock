package com.webtechlabs.gestionstock.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AuthRequestDto {

    @NotNull(message = "Email is required")
    @Email(message = "Email should be valid")
    String email;

    @NotNull(message = "Password is required")
    String password;
}