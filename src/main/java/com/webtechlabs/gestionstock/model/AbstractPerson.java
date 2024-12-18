package com.webtechlabs.gestionstock.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class AbstractPerson extends AbstractIdentifier {

    @Column(name = "name", nullable = false)
    protected String name;

    @Embedded
    protected Address address;

    @Embedded
    protected ContactPerson contact;
}
