package com.webtechlabs.gestionstock.service.impl;

import com.webtechlabs.gestionstock.dto.UserCreateDto;
import com.webtechlabs.gestionstock.enums.ERole;
import com.webtechlabs.gestionstock.mapper.UserMapper;
import com.webtechlabs.gestionstock.model.Role;
import com.webtechlabs.gestionstock.model.User;
import com.webtechlabs.gestionstock.repository.RoleRepository;
import com.webtechlabs.gestionstock.repository.UserRepository;
import com.webtechlabs.gestionstock.service.UserService;

import lombok.RequiredArgsConstructor;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void create(UserCreateDto userCreateDto) {
        findByEmail(userCreateDto.getEmail()).ifPresent(user -> {
            throw new IllegalArgumentException("Email already exists");
        });

        Role role = roleRepository.findByName(ERole.ROLE_USER)
                .orElseThrow(() -> new IllegalArgumentException("Default role not found"));

        User newUser = UserMapper.INSTANCE.userDtoToUser(userCreateDto);
        newUser.setPassword(passwordEncoder.encode(userCreateDto.getPassword()));
        newUser.setRoles(Set.of(role));
        
        userRepository.save(newUser);
    }

    @Override
    public UserCreateDto update(String uuid, UserCreateDto userCreateDto) {
        return null;
    }

    @Override
    public void delete(String uuid) {

    }
}
