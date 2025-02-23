package com.app.todo.TodoApp.service;

import com.app.todo.TodoApp.entity.Task;
import com.app.todo.TodoApp.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService{
    private final TaskRepository taskRepository;

    @Autowired
    TaskServiceImpl(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Task> getTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task updateTask(Long id, Task task) {
        Task updateTask = taskRepository.findById(id).orElseThrow(() -> new RuntimeException("id not found"));
        updateTask.setTitle(task.getTitle());
        updateTask.setBody(task.getBody());
        updateTask.setDueDate(task.getDueDate());
        updateTask.setCompleted(task.isCompleted());
        return taskRepository.save(updateTask);
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}
