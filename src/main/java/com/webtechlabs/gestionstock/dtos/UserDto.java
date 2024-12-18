package com.webtechlabs.gestionstock.dtos;

import lombok.Data;
import lombok.Value;

import java.io.Serializable;
import java.util.Set;

@Data
public class UserDto {
    private String uuid;
    private String email;
    private String password;
    private Set<String> roles;
}