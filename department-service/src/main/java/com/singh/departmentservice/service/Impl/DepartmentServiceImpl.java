package com.singh.departmentservice.service.Impl;

import com.singh.departmentservice.dto.DepartmentDto;
import com.singh.departmentservice.entity.Department;
import com.singh.departmentservice.mapper.DepartmentMapper;
import com.singh.departmentservice.repository.DepartmentRepository;
import com.singh.departmentservice.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
   private DepartmentRepository departmentRepository;
    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
        //convert department dto to department jpa entity
        Department department= DepartmentMapper.maptoDepartment(departmentDto);
     Department savedDepartment=   departmentRepository.save(department);
        DepartmentDto savedDepartmentDto=DepartmentMapper.mapToDepartmentDto(savedDepartment);
        return savedDepartmentDto;
    }

    @Override
    public DepartmentDto getDepartmentByCode(String departmentCode) {
        Department department=departmentRepository.findByDepartmentCode(departmentCode);
        DepartmentDto departmentDto=DepartmentMapper.mapToDepartmentDto(department);
        return departmentDto;
    }
}

