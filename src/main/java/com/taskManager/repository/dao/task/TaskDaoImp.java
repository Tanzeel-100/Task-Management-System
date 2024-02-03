package com.taskManager.repository.dao.task;

import com.taskManager.repository.entities.Task;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

import java.util.List;

@Setter
@Repository
public class TaskDaoImp implements TaskDao {
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @PostConstruct
    public void init() {
        System.out.println("Initialised taskDaoImp object");
    }

    @Override
    @Transactional
    public int addTask(Task task) {
        hibernateTemplate.save(task);
        return 0;
    }

    @Override
    public List<Task> getTasks() {
        List<Task> tasksList = hibernateTemplate.loadAll(Task.class);
        return tasksList;
    }

    @Override
    public Task getTask(Long id) {
        Task task = hibernateTemplate.get(Task.class, id);
        return task;
    }

    @Override
    @Transactional
    public void updateTask(Task task) {
        hibernateTemplate.update(task);
    }

    @Override
    @Transactional
    public void deleteTask(Long id) {
        Task task = hibernateTemplate.get(Task.class,id);
        hibernateTemplate.delete(task);
    }

}
