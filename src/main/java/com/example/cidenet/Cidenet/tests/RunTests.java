package com.example.cidenet.Cidenet.tests;

import com.example.cidenet.Cidenet.services.EmployeeService;
import com.example.cidenet.Cidenet.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RunTests {

    @Autowired
    EmployeeService employeeService;
    UserService userService = new UserService();

    public void run() {

        System.out.println(employeeService.generateEmail("SANDRO", "ALEXANDRO", "Colombia"));

    }
}
