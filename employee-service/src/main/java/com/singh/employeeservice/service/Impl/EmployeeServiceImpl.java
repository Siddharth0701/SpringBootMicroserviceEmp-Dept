package com.singh.employeeservice.service.Impl;

import com.singh.employeeservice.dto.ApiResponseDto;
import com.singh.employeeservice.dto.DepartmentDto;
import com.singh.employeeservice.dto.EmployeeDto;
import com.singh.employeeservice.entity.Employee;
import com.singh.employeeservice.repository.EmployeeRepository;
import com.singh.employeeservice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
//    @Autowired
//    private RestTemplate restTemplate;
    @Autowired
    private WebClient webClient;
    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee employee=new Employee(
          employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail(),
                employeeDto.getDepartmentCode()
        );
        Employee savedEmployee = employeeRepository.save(employee);
        EmployeeDto savedEmployeeDto=new EmployeeDto(
                savedEmployee.getId(),
                savedEmployee.getFirstName(),
                savedEmployee.getLastName(),
                savedEmployee.getEmail(),
                savedEmployee.getDepartmentCode()
        );
        return savedEmployeeDto;
    }

    @Override
    public ApiResponseDto getEmployeeById(Long employeeId) {
        Employee employee=employeeRepository.findById(employeeId).get();
//        ResponseEntity<DepartmentDto> restTemplateForEntity = restTemplate.getForEntity("http://localhost:8080/api/departments/" + employee.getDepartmentCode(), DepartmentDto.class);
//        DepartmentDto departmentDto=restTemplateForEntity.getBody();
        DepartmentDto departmentDto=  webClient.get().uri("http://localhost:8080/api/departments/"+employee.getDepartmentCode()).retrieve().bodyToMono(DepartmentDto.class).block();
        EmployeeDto employeeDto=new EmployeeDto(
          employee.getId(),
          employee.getFirstName(),
          employee.getLastName(),
          employee.getEmail(),
                employee.getDepartmentCode()
        );
        ApiResponseDto apiResponseDto=new ApiResponseDto();
        apiResponseDto.setEmployeeDto(employeeDto);
        apiResponseDto.setDepartmentDto(departmentDto);
        return apiResponseDto;
    }
}
