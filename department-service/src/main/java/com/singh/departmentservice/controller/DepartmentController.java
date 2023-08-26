package com.singh.departmentservice.controller;

import com.singh.departmentservice.dto.DepartmentDto;
import com.singh.departmentservice.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/departments")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    //Build save department REST Api
    @PostMapping
    public ResponseEntity<DepartmentDto> saveDepartment( @RequestBody DepartmentDto  departmentDto){
           DepartmentDto saveDepartmentDto= departmentService.saveDepartment(departmentDto);
           return  new ResponseEntity<>(saveDepartmentDto,HttpStatus.CREATED);
    }
    //Build get department
    @GetMapping("{department-code}")
    public  ResponseEntity<DepartmentDto> getDepartmentByCode(@PathVariable("department-code") String departmentCode ){
        DepartmentDto departmentByCode = departmentService.getDepartmentByCode(departmentCode);
        return  new ResponseEntity<>(departmentByCode,HttpStatus.OK);

    }
}
