package com.app.todo.TodoApp.controller;

import com.app.todo.TodoApp.entity.Task;
import com.app.todo.TodoApp.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    TaskRepository taskRepository;

    @GetMapping
    public List<Task> getTasks(){
        return taskRepository.findAll();

    }

    @PostMapping
    public Task saveTask(@RequestBody Task task){
        return taskRepository.save(task);
    }

    @PutMapping("{id}")
    public Task updateTask(@PathVariable("id") Long id, @RequestBody Task task){
        Task updateTask = taskRepository.findById(id).orElseThrow(() -> new RuntimeException("id not found"));
        updateTask.setTitle(task.getTitle());
        updateTask.setBody(task.getBody());
        updateTask.setDueDate(task.getDueDate());
        updateTask.setCompleted(task.isCompleted());
        return taskRepository.save(updateTask);
    }

    @DeleteMapping("{id}")
    public void deleteTask(@PathVariable("id") Long id){
        taskRepository.deleteById(id);

    }

}
