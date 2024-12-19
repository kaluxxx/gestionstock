package com.webtechlabs.gestionstock.utils;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Optional;

@RequiredArgsConstructor
public class AuthTokenFilter extends OncePerRequestFilter {
    private static final String BEARER_PREFIX = "Bearer ";
    private static final Logger logger = LoggerFactory.getLogger(AuthTokenFilter.class);
    private final JwtUtils jwtUtils;
    private final UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull FilterChain filterChain) throws ServletException, IOException {
        try {
            Optional<String> jwtToken = getJwtTokenByRequest(request);
            if (jwtToken.isPresent() && jwtUtils.validateJwtToken(jwtToken.get())) this.setAuthentication(jwtToken.get(), request);
        }

        catch (Exception e) {
            logger.error("Cannot set user authentication: {}", e.getMessage());
        }

        filterChain.doFilter(request, response);
    }

    private Optional<String> getJwtTokenByRequest(HttpServletRequest request) {
        return Optional.ofNullable(request.getHeader("Authorization"))
                .filter(authHeaderValue -> authHeaderValue.startsWith(BEARER_PREFIX))
                .map(authHeaderValue -> authHeaderValue.substring(BEARER_PREFIX.length()));
    }

    private void setAuthentication(String jwtToken, HttpServletRequest request) {
        String email = jwtUtils.getEmailByJwtToken(jwtToken);
        UserDetails userDetails = userDetailsService.loadUserByUsername(email);
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }
}
