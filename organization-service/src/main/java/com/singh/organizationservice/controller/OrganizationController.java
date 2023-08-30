package com.singh.organizationservice.controller;

import com.singh.organizationservice.dto.OrganizationDto;
import com.singh.organizationservice.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/organization")
public class OrganizationController {
    @Autowired
    private OrganizationService organizationService;
@PostMapping
    public ResponseEntity<OrganizationDto> saveOrganization(@RequestBody OrganizationDto organizationDto){
        OrganizationDto dto = organizationService.saveOrganization(organizationDto);
        return  new ResponseEntity<>(dto, HttpStatus.CREATED);
    }
    @GetMapping("{code}")
    public  ResponseEntity<OrganizationDto>findByOrganizatioCode(@PathVariable("code") String organizationCode ){
        OrganizationDto byOrganizationCode = organizationService.findByOrganizationCode(organizationCode);
        return new ResponseEntity<>(byOrganizationCode,HttpStatus.OK);

    }
}
