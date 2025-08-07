package com.taskmanager.controller;

import com.taskmanager.model.Task;
import com.taskmanager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@CrossOrigin("*")

public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping
    public Task addTask(@RequestBody Task task) {
        System.out.println("Received Task: " + task.getTitle());
        return taskService.addTask(task);
    }


    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable String id, @RequestBody Task task) {
        return taskService.updateTask(id, task);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable String id) {
        taskService.deleteTask(id);
    }
}
