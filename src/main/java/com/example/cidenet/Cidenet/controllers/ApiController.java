package com.example.cidenet.Cidenet.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

public class ApiController {
    @Controller
    @RequestMapping("/")
    public class ApiControllers {

        @GetMapping("/")
        public String getPage() {
            return "index.html";
        }

        @GetMapping("/error")
        public String exception(){
            return("Error");
        }

    }

}
