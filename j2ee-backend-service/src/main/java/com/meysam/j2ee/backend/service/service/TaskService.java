package com.meysam.j2ee.backend.service.service;

import com.meysam.j2ee.backend.service.model.Task;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/*here we implement a stateless session bean for the business logic. This class will interact with the database using JPA.*/

@Stateless
public class TaskService {

    @PersistenceContext
    private EntityManager em;

    public List<Task> getAllTasks() {
        return em.createQuery("SELECT t FROM Task t", Task.class).getResultList();
    }

    public void addTask(Task task) {
        em.persist(task);
    }

    public void deleteTask(Long id) {
        Task task = em.find(Task.class, id);
        if (task != null) {
            em.remove(task);
        }
    }
}
