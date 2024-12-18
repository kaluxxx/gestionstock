package com.webtechlabs.gestionstock.dto;

import lombok.Data;

import java.util.Set;

@Data
public class UserDto {
    private String uuid;
    private String email;
    private String password;
    private Set<String> roles;
}