package com.example.emsspringbootbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication (exclude = {SecurityAutoConfiguration.class})
public class EmsSpringbootBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmsSpringbootBackendApplication.class, args);
        System.out.println("Employee Management Server is running on port 8081...");
    }

}
