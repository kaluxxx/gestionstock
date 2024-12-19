package com.webtechlabs.gestionstock.model;

import com.webtechlabs.gestionstock.enums.ERole;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "roles")
public class Role extends AbstractIdentifier {

    @Enumerated(EnumType.STRING)
    @Column(name = "name", nullable = false, unique = true)
    private ERole name;

    @Column(name = "description", nullable = false)
    private String description;
}
