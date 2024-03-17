package com.example.cidenet.Cidenet.controllers;

import com.example.cidenet.Cidenet.entities.User;
import com.example.cidenet.Cidenet.exceptions.MyException;
import com.example.cidenet.Cidenet.repo.UserRepo;
import com.example.cidenet.Cidenet.services.EmployeeService;
import com.example.cidenet.Cidenet.services.UserService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParser;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URL;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/users") //Localhost/users
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    //Autowired se encarga de 'inyectar' la dependencia userRepo (dependencia como una porción de codigo que voy a poder volver a utilizar)
    private UserRepo userRepo;

    @GetMapping({"/", ""}) //Localhost/users
    public List<User> getUsers(@RequestParam(required = false) List<Long> ids){

        try{
            if (ids==null || ids.isEmpty()){
                return userService.getUsers();
            }else {
                return userService.getUsers(ids);
            }
        }catch(Exception e){
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, "Error id is not a number", e);
            System.out.println("The ids were not Longs");
            return null;

        }

    }
    @PostMapping({"/",""})
    public String createUser(@RequestBody String body){

        try{
            JSONObject object = new JSONObject(body);
            System.out.println(object.getString("name"));
            return object.getString("name");
        }catch (Exception e){
            System.out.println(e.getMessage());
            return (e.getMessage() + " Está borracho mi fax");
        }


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


}

