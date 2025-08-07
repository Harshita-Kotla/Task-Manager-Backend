package com.taskmanager.service;

import com.taskmanager.model.Task;
import com.taskmanager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public Task addTask(Task task) {
        return taskRepository.save(task);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task updateTask(String id, Task task) {
        task.setId(id);
        return taskRepository.save(task);
    }

    public void deleteTask(String id) {
        taskRepository.deleteById(id);
    }
}
