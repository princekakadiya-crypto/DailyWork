package com.tss.__jpa_app.service;

import com.tss.__jpa_app.dto.EmployeeRequestDto;
import com.tss.__jpa_app.dto.EmployeeResponseDto;
import com.tss.__jpa_app.entity.Employee;
import com.tss.__jpa_app.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeRepository employeeRepository;

    @Override
    public List<EmployeeResponseDto> getAllEmployee() {
        List<Employee> results= employeeRepository.findAll();
        List<EmployeeResponseDto> employeeResponseDtos=new ArrayList<>();

        for (Employee employee:results){
            employeeResponseDtos.add(employeeToEmployeeResponseDto(employee));
        }

        return employeeResponseDtos;

    }

    @Override
    public EmployeeResponseDto getEmployeeById(Long id) {
        Employee result= employeeRepository.findById(id).orElseThrow(
                ()->new RuntimeException("Employee id does not exists.")
        );
        return employeeToEmployeeResponseDto(result);
    }

    @Override
    public EmployeeResponseDto addEmployee(EmployeeRequestDto dto) {
        Employee employee=employeeRequestDtoToEmployee(dto);
        Employee result = employeeRepository.save(employee);
        return employeeToEmployeeResponseDto(result);
    }

    private Employee employeeRequestDtoToEmployee(EmployeeRequestDto dto){
        Employee employee=new Employee();
        employee.setName(dto.getName());
        employee.setDepartment(dto.getDepartment());
        return employee;
    }

    private EmployeeResponseDto employeeToEmployeeResponseDto(Employee employee){
        EmployeeResponseDto employeeResponseDto=new EmployeeResponseDto();
        employeeResponseDto.setId(employee.getId());
        employeeResponseDto.setName(employee.getName());
        return employeeResponseDto;
    }

}
