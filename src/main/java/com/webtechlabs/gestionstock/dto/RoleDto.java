package com.webtechlabs.gestionstock.dto;

import com.webtechlabs.gestionstock.enums.ERole;
import lombok.Data;

@Data
public class RoleDto {
    String uuid;
    ERole name;
    String description;
}