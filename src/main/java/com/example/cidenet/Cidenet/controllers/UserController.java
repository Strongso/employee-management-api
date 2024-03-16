package com.example.cidenet.Cidenet.controllers;

import com.example.cidenet.Cidenet.entities.User;
import com.example.cidenet.Cidenet.exceptions.MyException;
import com.example.cidenet.Cidenet.repo.UserRepo;
import com.example.cidenet.Cidenet.services.EmployeeService;
import com.example.cidenet.Cidenet.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user") //Localhost/user
public class UserController {

    @Autowired
    private Environment environment;

    @Autowired
    UserService userService;
    @Autowired
    EmployeeService employeeService;

    @Autowired
    //Autowired se encarga de 'inyectar' la dependencia userRepo (dependencia como una porción de codigo que voy a poder volver a utilizar)
    private UserRepo userRepo;

    @GetMapping({"/", ""}) //Localhost/user
    public String userPage() {
        userService.createUser("Username", "pass123");
        return ("user_main_page.html");

    }

    @GetMapping("/users") //Localhost/user/users
    public List<User> getUsers() {
        return userService.getUsers();
    }


    @GetMapping("/modify")
    public String modifyUser() throws MyException {
        userService.modifyUsernameById("modifiedAdmin", 1L);
        return "User modified... ";
    }

    @GetMapping("/delete")
    public String deleteUser() throws MyException {
        userService.deleteUserById(1L);
        return "User deleted... ";
    }

    @GetMapping("/delete-all-modofocos")
    public String deleteAllUsers() {
        userService.deleteAllUsers();
        return "All users deleted...";
    }


    @GetMapping("/admin") //Localhost/user/admin
    public String adminPage() {
        return "Admin Page";
    }

    @GetMapping("/admin/create-employee") //Localhost/user/admin/...
    public String adminCreateEmployee() {
        return "Created Employee. ";

    }

    @GetMapping("/admin/modify-employee")
    public String adminModifyEmployee() {
        return "Admin Modifies employee";
    }

    @GetMapping("/admin/delete-employee")
    public String adminDeleteEmployee() {
        return "Admin deletes employee";
    }

}

