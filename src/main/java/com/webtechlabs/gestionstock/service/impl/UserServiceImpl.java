package com.webtechlabs.gestionstock.service.impl;

import com.webtechlabs.gestionstock.dto.UserDto;
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
    public void register(UserDto userDto) {
        if (findByEmail(userDto.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Email already exists");
        }

        Role role = roleRepository.findByName(ERole.ROLE_USER)
                .orElseThrow(() -> new IllegalArgumentException("Default role not found"));

        User newUser = UserMapper.INSTANCE.userDtoToUser(userDto);
        newUser.setPassword(passwordEncoder.encode(userDto.getPassword()));
        newUser.setRoles(Set.of(role));
        
        userRepository.save(newUser);
    }

    @Override
    public UserDto authenticate(UserDto userDto) {
        return null;
    }

    @Override
    public UserDto update(String uuid, UserDto userDto) {
        return null;
    }

    @Override
    public void delete(String uuid) {

    }
}
