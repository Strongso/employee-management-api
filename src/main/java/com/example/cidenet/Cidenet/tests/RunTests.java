package com.example.cidenet.Cidenet.tests;

import com.example.cidenet.Cidenet.services.EmployeeService;
import com.example.cidenet.Cidenet.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;


@Component
public class RunTests {

    @Autowired
    EmployeeService employeeService;
    UserService userService = new UserService();
    public void run(){

        System.out.println(employeeService.generateEmail("SANDRO","ALEXANDRO","Colombia"));

        /*try {
            employeeService.validateName("");
            System.out.println("Todo bien");
        }catch (MyException e){
            System.out.println(e.getMessage());
        }*/

        /*
         /*
        try {
            employeeService.validateName("Alex");
            System.out.println("Todo bien");
        }catch (MyException e){
            System.out.println(e.getMessage());
        }
        try {
            employeeService.validateName("ALEX");
            System.out.println("All good with this name");
        }catch (MyException e){
            System.out.println(e.getMessage());
        }
        try {
            employeeService.validateSecondName("ALEXANDERPERODEMASIADOLARGOOOXX");
            System.out.println("All good with this second name");
        }catch (MyException e){
            System.out.println(e.getMessage());
        }
        try {
            employeeService.validateSecondName("ALEXANDERPERODEMASIADOLARGOOOXXPEROEXAGERADISIMAMENTEEE");
            System.out.println("Todo bien");
        }catch (MyException e){
            System.out.println(e.getMessage());
        }*//*

        try {
            employeeService.validateSecondName("ALEXANDER PERO LARGOOOXX");
            System.out.println("All good with this second name");
        }catch (MyException e){
            System.out.println(e.getMessage());
        }

        try {
            employeeService.validateIdNumber("zanDrOx123-yes");
            System.out.println("All good with this id");
        }catch (MyException e){
            System.out.println(e.getMessage());
        }
        try {
            employeeService.validateIdNumber("zanDrOx123-yes**");
            System.out.println("All good with this id");
        }catch (MyException e){
            System.out.println(e.getMessage());
        }*/
    }
}
