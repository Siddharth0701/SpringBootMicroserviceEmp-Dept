package com.singh.employeeservice.service;

import com.singh.employeeservice.dto.ApiResponseDto;
import com.singh.employeeservice.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);
    ApiResponseDto getEmployeeById(Long id);
}
