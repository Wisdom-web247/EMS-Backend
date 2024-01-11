package com.example.emsspringbootbackend;

import com.example.emsspringbootbackend.Models.Employee;
import com.example.emsspringbootbackend.Repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EmsSpringbootBackendApplicationTests {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Test
    void testCreateEmployee() {
        Employee employee = new Employee();
        employee.setFirstName("Peter");
        employee.setLastName("Doe");
        employee.setContactNo("12334567890");
        employee.setEmail("peterdoe17@gmail.com");
        employee.setAddress("123 Main St, New York, NY 10001");
        employee.setDepartment("Accounting");
        employee.setOccupation("Chartered Accountant");
        employeeRepository.save(employee);
    }

    @Test
    void testUpdateStudent() {
        Employee employee = employeeRepository.findById(1L).get();
        employee.setFirstName("Jane");
        employee.setLastName("Doe");
        employee.setContactNo("1234567890");
        employee.setEmail("janedoe21@gmail.com");
        employee.setAddress("321 Main St, New York, NY 10001");
        employee.setDepartment("IT");
        employeeRepository.save(employee);
    }

    @Test
    void testDeleteStudent() {
        employeeRepository.deleteById(3L);
    }
    @Test
    void testGetStudent() {
        Employee employee = employeeRepository.findById(1L).get();
        System.out.println(employee);
    }
    @Test
    void testGetAllStudents() {
        System.out.println(employeeRepository.findAll());
    }
}
