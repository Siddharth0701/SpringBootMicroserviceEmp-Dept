package com.singh.departmentservice.service;

import com.singh.departmentservice.dto.DepartmentDto;

public interface DepartmentService {

    DepartmentDto saveDepartment( DepartmentDto departmentDto);
    DepartmentDto getDepartmentByCode(String code);
}
