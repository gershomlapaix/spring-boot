package com.proj.derbyExample.controllers;

import com.proj.derbyExample.models.User;
import com.proj.derbyExample.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping(value = "/add-user")
    public void addUser(@RequestBody User user){
        userService.addUser(user);
    }
}
