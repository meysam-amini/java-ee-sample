package com.meysam.j2ee.backend.service.service;

import com.meysam.j2ee.backend.service.model.Task;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

/*here we implement a stateless session bean for the business logic. This class will interact with the database using JPA.*/

@Stateless
public class TaskService {

    @PersistenceContext
    private EntityManager em;

    public List<Task> getAllTasks() {
        return em.createQuery("SELECT t FROM Task t", Task.class).getResultList();
    }

    public Task addTask(Task task) {
        em.persist(task);
        return task;
    }

    public Task findTask(Long id) {
        return em.find(Task.class, id);
    }

    public void deleteTask(Long id) {
        Task task = em.find(Task.class, id);
        if (task != null) {
            em.remove(task);
        }
    }
}
