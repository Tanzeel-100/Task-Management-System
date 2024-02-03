package com.taskManager.controller;

import com.taskManager.repository.entities.Task;
import com.taskManager.service.TaskService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Setter
@Controller
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/tasks")
    public String showTasks(Model m) {
        List<Task> list = taskService.getTasks();
        m.addAttribute("taskList",list);
        return "tasks";
    }

    @GetMapping("/add-task")
    public String addTask() {
        return "addTask";
    }

    @PostMapping(value = "task-added", consumes = "application/json")
    public ResponseEntity<Map<String,String>> prcessTask(@RequestBody Task task) {
        Map<String, String> response = new HashMap<>();
        System.out.println(task);
        taskService.addTask(task);
        System.out.println("Task added");
        response.put("status", "success");
        response.put("message", "Task Added");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
