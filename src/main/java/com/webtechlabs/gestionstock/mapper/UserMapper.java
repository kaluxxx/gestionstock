package com.webtechlabs.gestionstock.mapper;

import com.webtechlabs.gestionstock.dto.UserCreateDto;
import com.webtechlabs.gestionstock.enums.ERole;
import com.webtechlabs.gestionstock.model.Role;
import com.webtechlabs.gestionstock.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(source = "roles", target = "roles", qualifiedByName = "roleSetToStringSet")
    UserCreateDto userToUserDto(User user);

    @Mapping(source = "roles", target = "roles", qualifiedByName = "stringSetToRoleSet")
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "company", ignore = true)
    @Mapping(target = "stockMovements", ignore = true)
    User userDtoToUser(UserCreateDto userCreateDto);

    @Named("roleSetToStringSet")
    default Set<String> roleSetToStringSet(Set<Role> roles) {
        if (roles == null) return null;

        return roles.stream().map(role -> role.getName().toString()).collect(Collectors.toSet());
    }

    @Named("stringSetToRoleSet")
    default Set<Role> stringSetToRoleSet(Set<String> roles) {
        if (roles == null) return null;

        return roles.stream().map(roleName -> {
            Role role = new Role();
            role.setName(ERole.valueOf(roleName));
            return role;
        }).collect(Collectors.toSet());
    }
}