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
        employee.setFirstName("John");
        employee.setLastName("Doe");
        employee.setContactNo("1234567890");
        employee.setEmail("johndoe17@gmail.com");
        employee.setAddress("123 Main St, New York, NY 10001");
        employee.setDepartment("IT");
        employee.setOccupation("Software Engineer");
        employeeRepository.save(employee);
    }

}
