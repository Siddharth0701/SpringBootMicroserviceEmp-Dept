package com.singh.organizationservice.service.Impl;

import com.singh.organizationservice.dto.OrganizationDto;
import com.singh.organizationservice.entity.Organization;
import com.singh.organizationservice.mapper.OrganizationMapper;
import com.singh.organizationservice.repository.OrganizationRepository;
import com.singh.organizationservice.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrganizationServiceImpl  implements OrganizationService {
    @Autowired
    private OrganizationRepository organizationRepository;

    @Override
    public OrganizationDto saveOrganization(OrganizationDto organizationDto) {
        //convert department dto to department jpa entity
        Organization organization= OrganizationMapper.mapToOrganization(organizationDto);
        Organization savedOrgaiization = organizationRepository.save(organization);
        OrganizationDto organizationDto1 = OrganizationMapper.mapToOrganizationDto(savedOrgaiization);
        return organizationDto1;
    }

    @Override
    public OrganizationDto findByOrganizationCode(String organizationCode) {
        Organization organization=organizationRepository.findByOrganizationCode(organizationCode);
       OrganizationDto dto= OrganizationMapper.mapToOrganizationDto(organization);
        return dto;
    }
}
