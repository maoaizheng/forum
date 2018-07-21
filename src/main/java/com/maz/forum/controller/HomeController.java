package com.maz.forum.controller;

import com.maz.forum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/register")
    private String index(@RequestParam String userName, @RequestParam String password){
        userService.register(userName, password);
        return "Hello Spring Boot!";
    }
}