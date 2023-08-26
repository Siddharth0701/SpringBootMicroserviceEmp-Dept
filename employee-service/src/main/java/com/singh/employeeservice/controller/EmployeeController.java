package com.singh.employeeservice.controller;

import com.singh.employeeservice.dto.ApiResponseDto;
import com.singh.employeeservice.dto.EmployeeDto;
import com.singh.employeeservice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
@PostMapping
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto savedEmployee = employeeService.saveEmployee(employeeDto);
        return  new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }
    //Build Get Employee REST API
    @GetMapping("{id}")
    public ResponseEntity<ApiResponseDto> getEmployeeById(@PathVariable("id") Long employeeId){
    ApiResponseDto apiResponseDto=employeeService.getEmployeeById(employeeId);
    return new ResponseEntity<>(apiResponseDto,HttpStatus.OK);
    }
}
