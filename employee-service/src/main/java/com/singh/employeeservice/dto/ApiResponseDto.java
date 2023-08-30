package com.singh.employeeservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public class ApiResponseDto {
    private EmployeeDto employeeDto;
    private  DepartmentDto departmentDto;
    private  OrganizationDto organizationDto;

    public ApiResponseDto(){
        super();
    }

    public ApiResponseDto(EmployeeDto employeeDto, DepartmentDto departmentDto, OrganizationDto organizationDto) {
        this.employeeDto = employeeDto;
        this.departmentDto = departmentDto;
        this.organizationDto = organizationDto;
    }

    public EmployeeDto getEmployeeDto() {
        return employeeDto;
    }

    public void setEmployeeDto(EmployeeDto employeeDto) {
        this.employeeDto = employeeDto;
    }

    public DepartmentDto getDepartmentDto() {
        return departmentDto;
    }

    public void setDepartmentDto(DepartmentDto departmentDto) {
        this.departmentDto = departmentDto;
    }

    public OrganizationDto getOrganizationDto() {
        return organizationDto;
    }

    public void setOrganizationDto(OrganizationDto organizationDto) {
        this.organizationDto = organizationDto;
    }
}
