package com.webtechlabs.gestionstock.service.impl;

import com.webtechlabs.gestionstock.dto.CompanyCreateDto;
import com.webtechlabs.gestionstock.mapper.CompanyMapper;
import com.webtechlabs.gestionstock.model.Company;
import com.webtechlabs.gestionstock.repository.CompanyRepository;
import com.webtechlabs.gestionstock.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    public Optional<Company> findBySiret(String siret) {
        return companyRepository.findBySiret(siret);
    }

    @Override
    public void create(CompanyCreateDto companyCreateDto) {
        findBySiret(companyCreateDto.getSiret()).ifPresent(company -> {
            throw new IllegalArgumentException("Company already exists");
        });

        Company newCompany = CompanyMapper.INSTANCE.companyCreateDtoToCompany(companyCreateDto);

        companyRepository.save(newCompany);
    }
}
