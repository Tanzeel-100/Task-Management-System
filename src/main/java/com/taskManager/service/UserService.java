package com.taskManager.service;

import com.taskManager.repository.dao.user.UserDao;
import com.taskManager.repository.entities.User;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
@Setter
public class UserService {
    @Autowired
    private UserDao userDaoImp;

    @PostConstruct
    public void init() {
        System.out.println("Initialised userService object");
    }

    public int registerUser(User user) {
        int res = userDaoImp.addUser(user);
        System.out.println("user inserted");
        return res;
    }

    public List<User> getUsers() {
        List<User> userList = userDaoImp.getUsers();
        return userList;
    }

}
