package com.example.emsspringbootbackend.Service;


import com.example.emsspringbootbackend.Models.Employee;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

  List<Employee> getAllEmployees();
  Optional<Employee> getEmployeeById(Long id);
  ResponseEntity<Employee> updateEmployee(Long empId, Employee employee);
  Employee addEmployee(Employee employee);
  void deleteEmployee(Long id);
}
