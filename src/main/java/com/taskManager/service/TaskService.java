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
    @Autowired
    private TaskDao taskDaoImp;

    @PostConstruct
    public void init() {
        System.out.println("Initialised taskService object");
    }

    public int addTask(Task task) {
        int res = taskDaoImp.addTask(task);
        System.out.println("task added");
        return res;
    }

    public List<Task> getTasks() {
        List<Task> taskList = taskDaoImp.getTasks();
        return taskList;
    }
}
