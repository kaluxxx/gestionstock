package com.webtechlabs.gestionstock.dtos;

import com.webtechlabs.gestionstock.enums.ERole;
import lombok.Data;
import lombok.Value;

import java.io.Serializable;
import java.time.Instant;

@Data
public class RoleDto {
    String uuid;
    ERole name;
    String description;
}