package com.webtechlabs.gestionstock.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class AbstractPerson extends AbstractIdentifier{

    @Column(name = "name", nullable = false)
    private String name;

    @Embedded
    private Address address;

    @Embedded
    private ContactPerson contact;
}
