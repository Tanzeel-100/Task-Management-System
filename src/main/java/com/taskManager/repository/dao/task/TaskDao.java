package com.taskManager.repository.dao.task;

import com.taskManager.repository.entities.Task;
import com.taskManager.repository.entities.User;

import java.util.List;

public interface TaskDao {
    public int addTask(Task task);
    public Task getTask(Long id);
    public List<Task> getTasks();
    public void updateTask(Task task);
    public void deleteTask(Long id);
}
