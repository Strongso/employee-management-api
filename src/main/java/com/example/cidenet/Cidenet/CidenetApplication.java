package com.example.cidenet.Cidenet;

import com.example.cidenet.Cidenet.services.EmployeeService;
import com.example.cidenet.Cidenet.tests.RunTests;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CidenetApplication {

    public static void main(String[] args) {
        SpringApplication.run(CidenetApplication.class, args);


        /*RunTests runTests = new RunTests();
        runTests.run();*/

    }
}
