package com.webtechlabs.gestionstock.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthResponseDto {

    private String token;

    private UserDetailDto user;
}