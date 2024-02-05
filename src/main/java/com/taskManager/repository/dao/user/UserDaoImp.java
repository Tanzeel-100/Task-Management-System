package com.taskManager.repository.dao.user;

import com.taskManager.repository.entities.User;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.List;

@Setter
@Repository
public class UserDaoImp implements UserDao {

    private HibernateTemplate hibernateTemplate;

    @Autowired
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @PostConstruct
    public void init() {
        System.out.println("Initialised userDaoImpl object");
    }

    @Override
    @Transactional
    public int addUser(User user) {
        hibernateTemplate.save(user);
        return 0;
    }

    @Override
    public User getUser(String email) {
        User user = hibernateTemplate.get(User.class,email);
        return user;
    }

    @Override
    public List<User> getUsers() {
        List<User> userList = hibernateTemplate.loadAll(User.class);
        return userList;
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        hibernateTemplate.update(user);
    }

    @Override
    @Transactional
    public void deleteUser(String email) {
        User user = hibernateTemplate.get(User.class,email);
        hibernateTemplate.delete(user);
    }
}
