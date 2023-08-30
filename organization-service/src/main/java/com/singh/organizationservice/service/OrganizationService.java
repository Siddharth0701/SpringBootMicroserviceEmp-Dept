package com.singh.organizationservice.service;

import com.singh.organizationservice.dto.OrganizationDto;

public interface OrganizationService {

    OrganizationDto saveOrganization(OrganizationDto organizationDto);

    OrganizationDto findByOrganizationCode(String organizationCode);

}
