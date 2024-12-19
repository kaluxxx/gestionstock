package com.webtechlabs.gestionstock.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor

public class UserDetailDto {
    private String email;

    private List<String> roles;
}