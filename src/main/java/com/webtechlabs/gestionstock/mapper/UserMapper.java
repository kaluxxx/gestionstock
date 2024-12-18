package com.webtechlabs.gestionstock.mapper;

import com.webtechlabs.gestionstock.dto.UserDto;
import com.webtechlabs.gestionstock.model.Role;
import com.webtechlabs.gestionstock.model.User;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.Set;
import java.util.stream.Collectors;

public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

//    @Mapping(source = "roles", target = "roles", qualifiedByName = "roleSetToStringSet")
    UserDto userToUserDto(User user);

    User userDtoToUser(UserDto userDto);

//    @Named("roleSetToStringSet")
//    default Set<String> roleSetToStringSet(Set<Role> roles) {
//        if (roles == null) return null;
//
//        return roles.stream().map(role -> role.getName().toString()).collect(Collectors.toSet());
//    }
}
