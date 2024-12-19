package com.webtechlabs.gestionstock.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "company")
public class Company extends AbstractPerson {

    @Column(name = "siret", nullable = false, unique = true)
    private String siret;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<User> users;

    @OneToMany(mappedBy = "company")
    private List<Product> products;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Supplier> suppliers;
}