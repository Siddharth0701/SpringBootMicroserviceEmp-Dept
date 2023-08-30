package com.singh.employeeservice.service.Impl;

import com.singh.employeeservice.dto.ApiResponseDto;
import com.singh.employeeservice.dto.DepartmentDto;
import com.singh.employeeservice.dto.EmployeeDto;
import com.singh.employeeservice.dto.OrganizationDto;
import com.singh.employeeservice.entity.Employee;
import com.singh.employeeservice.mapper.EmployeeMapper;
import com.singh.employeeservice.repository.EmployeeRepository;
import com.singh.employeeservice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
        Employee employee= EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        EmployeeDto savedEmployeeDto=EmployeeMapper.mapToEmployeeDto(savedEmployee);
        return savedEmployeeDto;
    }

    @Override
    public ApiResponseDto getEmployeeById(Long employeeId) {
        Employee employee=employeeRepository.findById(employeeId).get();
//        ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity("http://DEPARTMENT-SERVICE/api/departments/" + employee.getDepartmentCode(),
//                DepartmentDto.class);
//        DepartmentDto departmentDto = responseEntity.getBody();

        DepartmentDto departmentDto = webClient.get()
                .uri("http://localhost:8080/api/departments/" + employee.getDepartmentCode())
                .retrieve()
                .bodyToMono(DepartmentDto.class)
                .block();

        //  DepartmentDto departmentDto = apiClient.getDepartment(employee.getDepartmentCode());
        OrganizationDto organizationDto = webClient.get()
                .uri("http://localhost:8083/api/organization/" + employee.getOrganizationCode())
                .retrieve()
                .bodyToMono(OrganizationDto.class)
                .block();

        EmployeeDto employeeDto = EmployeeMapper.mapToEmployeeDto(employee);
        ApiResponseDto apiResponseDto = new ApiResponseDto();
        apiResponseDto.setEmployeeDto(employeeDto);
        apiResponseDto.setDepartmentDto(departmentDto);
        apiResponseDto.setOrganizationDto(organizationDto);
        return apiResponseDto;
    }
}
