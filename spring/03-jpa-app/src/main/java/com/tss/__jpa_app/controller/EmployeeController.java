package com.tss.__jpa_app.controller;

import com.tss.__jpa_app.dto.EmployeeRequestDto;
import com.tss.__jpa_app.dto.EmployeeResponseDto;
import com.tss.__jpa_app.entity.Employee;
import com.tss.__jpa_app.service.EmployeeServiceImpl;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/app/employee")
public class EmployeeController {

    private final EmployeeServiceImpl employeeService;

    @GetMapping()
    public ResponseEntity<List<EmployeeResponseDto>> getAllEmployee(){
        return new ResponseEntity<>(employeeService.getAllEmployee(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResponseDto> getEmployeeById(@PathVariable Long id){
        return new ResponseEntity<>(employeeService.getEmployeeById(id),HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<EmployeeResponseDto> addEmployee(@Valid @ModelAttribute EmployeeRequestDto employee){
        return new ResponseEntity<>(employeeService.addEmployee(employee),HttpStatus.CREATED);
    }


}
