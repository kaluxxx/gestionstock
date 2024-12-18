package com.webtechlabs.gestionstock.service;


import com.webtechlabs.gestionstock.dto.UserDto;
import com.webtechlabs.gestionstock.model.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

public interface UserService {

    Optional<User> findByEmail(String email);

    void register(UserDto userDto);

    UserDto authenticate(UserDto userDto);

    UserDto update(String uuid, UserDto userDto);

    void delete(String uuid);
}
