package com.webtechlabs.gestionstock.service;

import com.webtechlabs.gestionstock.dto.AuthRequestDto;
import com.webtechlabs.gestionstock.dto.AuthResponseDto;

public interface AuthService {

    AuthResponseDto login(AuthRequestDto authRequestDto);
}
