package com.webtechlabs.gestionstock.controller;

import com.webtechlabs.gestionstock.dto.CompanyCreateDto;
import com.webtechlabs.gestionstock.service.CompanyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/company")
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;

    @PostMapping("/")
    public ResponseEntity<Void> createCompany(@RequestBody @Valid CompanyCreateDto companyCreateDto) {
        companyService.create(companyCreateDto);
        return ResponseEntity.status(201).build();
    }
}
