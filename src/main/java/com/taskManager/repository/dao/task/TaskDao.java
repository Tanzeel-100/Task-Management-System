package com.taskManager.repository.dao.task;

import com.taskManager.repository.entities.Task;

import java.util.List;

public interface TaskDao {
    public int addTask(Task task);
    public List<Task> getTasks();
    public void updateTask(Task task);
    public Task getTask(int id);
    public void deleteTask(int id);
}
