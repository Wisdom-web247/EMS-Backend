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
//Constructor Injection
    @Autowired
    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }
//Testing the Api Status, return only if API is active
    @GetMapping(value = "/api-status")
    public String returnStatus(){
        return "SUCCESS! this API is working correctly!";
    }
//Admin to add new employee
    @PostMapping(value = "/employee")
    public Employee addEmployee(@RequestBody Employee employee){
        return employeeService.addEmployee(employee);

    }
//Admin to update Employee
    @PatchMapping (value = "/employee/{empId}")
    public Employee updateEmployee(@RequestBody Employee employee){

        return employeeService.updateEmployee(empId);

    }

     @GetMapping
    public List<EmployeeEntity> findAllEmployees() {
        return employeeService.findAllEmployees();
    }

    @GetMapping("/{id}")
    public Optional<EmployeeEntity> findEmployeeById(@PathVariable("id") Long id) {
        return employeeService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable("id") Long id) {
        employeeService.deleteEmployee(id);
    }
}
