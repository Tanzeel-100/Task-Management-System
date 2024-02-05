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

//@Setter
@Controller(value = "/tasks")
public class TaskController {

    private TaskService taskService;

    @Autowired
    public void setTaskService(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostConstruct
    public void init() {
        System.out.println("Initialized UserController");
    }

    //Fetch Tasks API
    @GetMapping("/")
    public ResponseEntity<Map<String, Object>> fetchTasks() {
        Map<String, Object> response = new HashMap<>();

        try {
            List<Task> list = taskService.getTasks();
            System.out.println("List of tasks: " + list);

            response.put("listOfTasks", list);
            response.put("status", "success");
            response.put("message", "Tasks Fetched");

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            // Log the exception or print the stack trace
            e.printStackTrace();

            response.put("status", "error");
            response.put("message", "Error fetching tasks");

            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Add Task API
    @PostMapping(value = "/", consumes = "application/json")
    public @ResponseBody ResponseEntity<Map<String, Object>> processTask(@RequestBody Task task) {
        Map<String, Object> response = new HashMap<>();

        try {
            //We assume that the taskId will not collide as it is auto incremented.

            System.out.println(task);
            taskService.addTask(task);
            System.out.println("Task added");

            response.put("task", task);
            response.put("status", "success");
            response.put("message", "Task Added");

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            // Log the exception or print the stack trace
            e.printStackTrace();

            response.put("status", "error");
            response.put("message", "Error processing the task");

            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Update Task API
    @PutMapping(value = "/{taskId}", consumes = "application/json")
    public ResponseEntity<Map<String, Object>> editTask(@RequestBody Task task, @PathVariable int taskId) {
        Map<String, Object> response = new HashMap<>();

        try {

            // Check if Task exists
            Task existingTask = taskService.getTask(taskId);
            System.out.println("Task : " + existingTask);
            if (existingTask == null) {
                response.put("status", "failed");
                response.put("message", "Task with ID " + taskId + " not found");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            }

            // Perform the update
            task.setTaskId(taskId);
            taskService.editTask(task);

            response.put("task", task);
            response.put("status", "success");
            response.put("message", "Task edited successfully");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("status", "error");
            response.put("message", "An error occurred while editing the task.");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    //Fetch Task API
    @GetMapping("/{taskId}")
    public ResponseEntity<Map<String, Object>> fetchTask(@PathVariable int taskId) {
        Map<String, Object> response = new HashMap<>();

        try {
            Task task = taskService.getTask(taskId);

            if (task == null) {
                response.put("status", "failed");
                response.put("message", "No Task found with ID: " + taskId);
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
            }

            System.out.println("Task: " + task);
            response.put("Task", task);
            response.put("status", "success");
            response.put("message", "Task Fetched");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.put("status", "error");
            response.put("message", "An error occurred while fetching the task.");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    //Delete Task API
    @DeleteMapping("/{taskId}")
    public ResponseEntity<Map<String, Object>> deleteTask(@PathVariable int taskId) {
        Map<String, Object> response = new HashMap<>();

        try {
            System.out.println("TaskId to be deleted: " + taskId);

            Task task = taskService.getTask(taskId);
            if(task == null) {
                response.put("status", "failed");
                response.put("message", "No Task found with ID: " + taskId);
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
            }

            taskService.deleteTask(taskId);
            System.out.println(taskId + " has been deleted.");
            response.put("status", "success");
            response.put("message", "Task deleted successfully");

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            // Log the exception or print the stack trace
            e.printStackTrace();

            response.put("status", "error");
            response.put("message", "Error deleting the task");

            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
