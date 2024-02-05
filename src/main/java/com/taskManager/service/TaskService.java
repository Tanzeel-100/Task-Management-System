package com.taskManager.service;

import com.taskManager.repository.dao.task.TaskDao;
import com.taskManager.repository.entities.Task;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Setter
@Service
public class TaskService {

    private TaskDao taskDaoImp;

    @Autowired
    public void setTaskDaoImp(TaskDao taskDaoImp) {
        this.taskDaoImp = taskDaoImp;
    }

    @PostConstruct
    public void init() {
        System.out.println("Initialised taskService object");
    }

    public int addTask(Task task) {
        int res = taskDaoImp.addTask(task);
        System.out.println("task added");
        return res;
    }

    public Task getTask(int id) {
        Task task = taskDaoImp.getTask(id);
        System.out.println("Task Fetched.");
        return task;
    }

    public List<Task> getTasks() {
        List<Task> taskList = taskDaoImp.getTasks();
        System.out.println("Tasks Fetched.");
        return taskList;
    }

    public void editTask(Task task) {
        taskDaoImp.updateTask(task);
        System.out.println("Task updated.");
    }

    public void deleteTask(int id) {
        taskDaoImp.deleteTask(id);
        System.out.println("Task with id" + id + "has been deleted.");
    }
}
