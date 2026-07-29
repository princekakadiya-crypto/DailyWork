package com.tss.__jpa_app.service;

import com.tss.__jpa_app.dto.EmployeeRequestDto;
import com.tss.__jpa_app.dto.EmployeeResponseDto;
import com.tss.__jpa_app.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<EmployeeResponseDto> getAllEmployee();
    EmployeeResponseDto getEmployeeById(Long id);
    EmployeeResponseDto addEmployee(EmployeeRequestDto employee);
}
