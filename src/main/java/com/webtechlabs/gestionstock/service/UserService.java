package com.webtechlabs.gestionstock.service;


import com.webtechlabs.gestionstock.dto.AuthRequestDto;
import com.webtechlabs.gestionstock.dto.AuthResponseDto;
import com.webtechlabs.gestionstock.dto.UserCreateDto;
import com.webtechlabs.gestionstock.model.User;

import java.util.Optional;

public interface UserService {

    Optional<User> findByEmail(String email);

    void create(UserCreateDto userCreateDto);

    UserCreateDto update(String uuid, UserCreateDto userCreateDto);

    void delete(String uuid);
}
