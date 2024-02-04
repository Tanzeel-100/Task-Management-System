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
import java.util.List;
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

    @PostMapping(value = "/register", consumes = "application/json")
    public @ResponseBody ResponseEntity<Map<String, Object>> processRegistration(@RequestBody User user) {
        Map<String, Object> response = new HashMap<>();
        System.out.println(user);
        userService.registerUser(user);
        System.out.println("User Registered");
        response.put("user",user);
        response.put("status", "success");
        response.put("message", "Registered Successfully");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(value = "/users")
    public ResponseEntity<Map<String,Object>> getUsers() {
        Map<String,Object> response = new HashMap<>();
        List<User> userList = userService.getUsers();
        System.out.println("Users list:" + userList);
        response.put("userList", userList);
        response.put("status", "success");
        response.put("message", "Users Fetched");
        return ResponseEntity.ok(response);
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String,String>> processLogin(@RequestBody User user) {
        Map<String, String> response = new HashMap<>();
        System.out.println(user);
        response.put("status", "success");
        response.put("message", "Login Successfully");
        System.out.println("User logged in");
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
