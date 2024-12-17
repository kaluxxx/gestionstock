package com.webtechlabs.gestionstock.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "company")
public class Company extends AbstractIdentifier {

    @Column(name = "name", nullable = false)
    private String name;

    @Embedded
    private Address address;

    @Embedded
    private ContactPerson contact;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<User> users;
}