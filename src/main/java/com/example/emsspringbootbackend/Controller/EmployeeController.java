package com.example.emsspringbootbackend.Controller;

import com.example.emsspringbootbackend.Models.Employee;
import com.example.emsspringbootbackend.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin("http://localhost:8081")
@RequestMapping(value = "/api/v1/employees")
@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping(value = "/api-status")
    public String returnStatus(){
        return "SUCCESS! this API is working correctly!";
    }

    @PostMapping(value = "/employee")
    public Employee addEmployee(@RequestBody Employee employee){
        return employeeService.addEmployee(employee);

    }

    @PutMapping (value = "/employee/{empId}")
    public Employee updateEmployee(@RequestBody Employee employee){

        return employeeService.updateEmployee(empId);

    }
}
