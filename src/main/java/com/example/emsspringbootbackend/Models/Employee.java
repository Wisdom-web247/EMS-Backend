package com.example.emsspringbootbackend.Models;


import jakarta.persistence.*;
import lombok.*;

@Entity(name = "employee")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Long empId;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email_address", nullable = false)
    private String email;

    @Column(name = "contact_no", nullable = false)
    private String contactNo;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "department", nullable = false)
    private String department;

    @Column(name = "occupation", nullable = false)
    private String occupation;

}
