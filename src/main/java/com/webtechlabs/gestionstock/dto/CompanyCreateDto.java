package com.webtechlabs.gestionstock.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Data
public class CompanyCreateDto{

    @NotNull(message = "Name cannot be null")
    @NotEmpty(message = "Name cannot be empty")
    @NotBlank(message = "Name cannot be blank")
    private String name;

    @NotNull(message = "Siret cannot be null")
    @NotEmpty(message = "Siret cannot be empty")
    @NotBlank(message = "Siret cannot be blank")
    private String siret;

    private AddressDto address;

    private ContactPersonDto contact;
}