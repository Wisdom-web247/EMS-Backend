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
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }

    @PatchMapping(value = "/employee/{empId}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("empId") Long empId, @RequestBody Employee employee) {
        return employeeService.updateEmployee(empId, employee);
    }

    @DeleteMapping(value = "/employee/{id}")
    public void deleteEmployee(@PathVariable("id") Long id) {
        employeeService.deleteEmployee(id);
    }

    @GetMapping(value = "/employee/{id}")
    public Employee getEmployeeById(@PathVariable("id") Long id) {
        return employeeService.getEmployeeById(id).orElseThrow();
    }

    @GetMapping(value = "/employees")
    public Iterable<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }
}
