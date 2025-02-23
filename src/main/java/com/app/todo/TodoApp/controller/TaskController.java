package com.app.todo.TodoApp.controller;

import com.app.todo.TodoApp.entity.Task;
import com.app.todo.TodoApp.service.TaskService;
import com.app.todo.TodoApp.service.TaskServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    TaskController(TaskService taskService){
        this.taskService = taskService;
    }

    @GetMapping
    public List<Task> getTasks(){
        return taskService.getTasks();

    }

    @PostMapping
    public Task saveTask(@RequestBody Task task){
        return taskService.saveTask(task);
    }

    @PutMapping("{id}")
    public Task updateTask(@PathVariable("id") Long id, @RequestBody Task task){
        return taskService.updateTask(id, task);
    }

    @DeleteMapping("{id}")
    public void deleteTask(@PathVariable("id") Long id){
        taskService.deleteTask(id);

    }

}
