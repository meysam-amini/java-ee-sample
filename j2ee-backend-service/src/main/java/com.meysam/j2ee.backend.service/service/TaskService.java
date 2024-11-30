package com.meysam.j2ee.backend.service.service;

import com.meysam.j2ee.backend.service.model.Task;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

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
