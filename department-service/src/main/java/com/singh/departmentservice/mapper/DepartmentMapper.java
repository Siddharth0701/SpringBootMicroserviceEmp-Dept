package com.singh.departmentservice.mapper;

import com.singh.departmentservice.dto.DepartmentDto;
import com.singh.departmentservice.entity.Department;

public class DepartmentMapper {

    public static DepartmentDto mapToDepartmentDto(Department department){
        DepartmentDto departmentDto=new DepartmentDto(
          department.getId(),
          department.getDepartmentName(),
          department.getDepartmentDescription(),
          department.getDepartmentCode()
        );
        return  departmentDto;
    }
    public  static Department maptoDepartment(DepartmentDto departmentDto){
        Department department=new Department(
          departmentDto.getId(),
          departmentDto.getDepartmentName(),
          departmentDto.getDepartmentDescription(),
                departmentDto.getDepartmentCode()
        );
        return department;
    }
}
