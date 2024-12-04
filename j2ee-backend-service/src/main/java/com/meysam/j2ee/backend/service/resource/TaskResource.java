package com.meysam.j2ee.backend.service.resource;

import com.meysam.j2ee.backend.service.model.Task;
import com.meysam.j2ee.backend.service.service.TaskService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

/*here we create a JAX-RS resource class to expose the TaskService methods as RESTful APIs.*/

@Path("/tasks")
public class TaskResource {

    @Inject
    private TaskService taskService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Task> getTasks() {
        return taskService.getAllTasks();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void createTask(Task task) {
        taskService.addTask(task);
    }

    @DELETE
    @Path("/{id}")
    public void deleteTask(@PathParam("id") Long id) {
        taskService.deleteTask(id);
    }
}
