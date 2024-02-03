package com.taskManager.controller;

import com.taskManager.repository.entities.User;
import com.taskManager.service.UserService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Setter
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @PostConstruct
    public void init() {
        System.out.println("Initialized UserController");
    }

    @RequestMapping("/register")
    public String showRegisterForm() {
        System.out.println("In the register page");
        return "register";
    }

    @PostMapping(value = "/register-user", consumes = "application/json")
    public @ResponseBody ResponseEntity<Map<String, String>> processRegistration(@RequestBody User user) {
        Map<String, String> response = new HashMap<>();
        // Perform registration logic
        System.out.println(user);
        userService.registerUser(user);
        System.out.println("User Registered");
        response.put("status", "success");
        response.put("message", "Registered Successfully");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping("/login")
    public String showLoginForm() {
        System.out.println("In the login page");
        return "login";
    }

    @PostMapping("/login-user")
    public ResponseEntity<Map<String,String>> processLogin(@RequestBody User user) {
        Map<String, String> response = new HashMap<>();
        System.out.println(user);
        response.put("status", "success");
        response.put("message", "Login Successfully");
        System.out.println("User logged in");
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
