package com.webtechlabs.gestionstock.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Data
public class AddressDto {

    @NotNull(message = "Street cannot be null")
    @NotEmpty(message = "Street cannot be empty")
    @NotBlank(message = "Street cannot be blank")
    private String street;

    @NotNull(message = "City cannot be null")
    @NotEmpty(message = "City cannot be empty")
    @NotBlank(message = "City cannot be blank")
    private String city;

    @NotNull(message = "Zip code cannot be null")
    @NotEmpty(message = "Zip cannot be empty")
    @NotBlank(message = "Zip cannot be blank")
    private String zipCode;

    @NotNull(message = "State cannot be null")
    @NotEmpty(message = "State cannot be empty")
    @NotBlank(message = "State cannot be blank")
    private String state;

    @NotNull(message = "Country cannot be null")
    @NotEmpty(message = "Country cannot be empty")
    @NotBlank(message = "Country cannot be blank")
    private String country;
}