package com.taskManager.repository.dao.user;

import com.taskManager.repository.entities.User;

import java.util.List;

public interface UserDao {
    public int addUser(User user);
    public User getUser(String email);
    public List<User> getUsers();
    public void updateUser(User user);
    public void deleteUser(String email);
}
