package com.webtechlabs.gestionstock.service.impl;

import com.webtechlabs.gestionstock.dto.AuthRequestDto;
import com.webtechlabs.gestionstock.dto.AuthResponseDto;
import com.webtechlabs.gestionstock.dto.UserDetailDto;
import com.webtechlabs.gestionstock.service.AuthService;
import com.webtechlabs.gestionstock.utils.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;

    @Override
    public AuthResponseDto login(AuthRequestDto authRequestDto) {
        Authentication authentication = getAuthentication(authRequestDto.getEmail(), authRequestDto.getPassword());

        return generateAuthResponse(authentication);
    }

    private Authentication getAuthentication(String email, String password) {
        return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
    }

    private AuthResponseDto generateAuthResponse(Authentication authentication) {
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        List<String> roles = userDetails.getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .toList();

        return new AuthResponseDto(
                jwt,
                new UserDetailDto(
                      userDetails.getUsername(),
                        roles
                )

        );
    }
}
