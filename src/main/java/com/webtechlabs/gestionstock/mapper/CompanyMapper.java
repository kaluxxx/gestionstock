package com.webtechlabs.gestionstock.mapper;

import com.webtechlabs.gestionstock.dto.CompanyCreateDto;
import com.webtechlabs.gestionstock.model.Company;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CompanyMapper {

    CompanyMapper INSTANCE = Mappers.getMapper(CompanyMapper.class);

    Company companyCreateDtoToCompany(CompanyCreateDto companyCreateDto);
}
