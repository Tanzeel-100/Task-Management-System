package com.taskManager.controller;

import com.taskManager.repository.entities.Task;
import com.taskManager.service.TaskService;
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
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostConstruct
    public void init() {
        System.out.println("Initialized UserController");
    }

    //Fetch Tasks API
    @GetMapping("/tasks")
    public ResponseEntity<Map<String, Object>> showTasks() {
        List<Task> list = taskService.getTasks();
        System.out.println("List of tasks: " + list);
        Map<String, Object> response = new HashMap<>();
        response.put("listOfTasks", list);
        response.put("status", "success");
        response.put("message", "Tasks Fetched");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //Insert API
    @PostMapping(value = "task-added", consumes = "application/json")
    public @ResponseBody ResponseEntity<Map<String,Object>> prcessTask(@RequestBody Task task) {
        Map<String, Object> response = new HashMap<>();
        System.out.println(task);
        taskService.addTask(task);
        System.out.println("Task added");
        response.put("task", task);
        response.put("status", "success");
        response.put("message", "Task Added");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //Update API
    @PutMapping(value = "tasks/{taskId}", consumes = "application/json")
    public @ResponseBody ResponseEntity<Map<String,Object>> editTask(@RequestBody Task task,@PathVariable int taskId) {
        Map<String,Object> response = new HashMap<>();
        System.out.println(task);
        taskService.editTask(task);
        System.out.println("Task with id:" + taskId + "edited");
        response.put("task", task);
        response.put("status", "success");
        response.put("message", "Task edited");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //Fetch Task API
    @GetMapping("/tasks/{taskId}")
    public ResponseEntity<Map<String, Object>> showTask(@PathVariable int taskId) {
        Task task = taskService.getTask(taskId);
        System.out.println("Task: " + task);
        Map<String, Object> response = new HashMap<>();
        response.put("Task", task);
        response.put("status", "success");
        response.put("message", "Tasks Fetched");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //Delete API
    @DeleteMapping("tasks/{taskId}")
    public ResponseEntity<Map<String, Object>> deleteTask(@PathVariable int taskId) {
        Map<String, Object> response = new HashMap<>();
        System.out.println("TasId to be deleted: " + taskId);
        // Assuming the taskId exist in the database
        taskService.deleteTask(taskId);
        System.out.println(taskId + " has been deleted.");
        response.put("status", "success");
        response.put("message", "Task deleted successfully");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}
