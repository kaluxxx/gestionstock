package com.webtechlabs.gestionstock.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "customers")
public class Customer extends AbstractPerson {

}