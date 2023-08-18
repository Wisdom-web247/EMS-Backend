package com.example.emsspringbootbackend.Service;

import com.example.emsspringbootbackend.Models.Employee;
import com.example.emsspringbootbackend.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    //Constructor Injection
    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public ResponseEntity<Employee> updateEmployee(Long empId, Employee employee) {

        Employee updateEmployee = employeeRepository.findById(empId).orElseThrow();

        updateEmployee.setFirstName(employee.getFirstName());
        updateEmployee.setLastName(employee.getLastName());
        updateEmployee.setContactNo(employee.getContactNo());
        updateEmployee.setEmail(employee.getEmail());
        updateEmployee.setAddress(employee.getAddress());
        updateEmployee.setDepartment(employee.getDepartment());
        updateEmployee.setOccupation(employee.getOccupation());

        employeeRepository.save(updateEmployee);

        return ResponseEntity.ok(updateEmployee);

    }

    @Override
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}
