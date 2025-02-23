package com.app.todo.TodoApp.controller;

import com.app.todo.TodoApp.dto.TaskDTO;
import com.app.todo.TodoApp.service.TaskService;
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
    public List<TaskDTO> getTasks(){
        return taskService.getTasks();

    }

    @PostMapping
    public TaskDTO saveTask(@RequestBody TaskDTO taskDTO){
        return taskService.saveTask(taskDTO);
    }

    @PutMapping("{id}")
    public TaskDTO updateTask(@PathVariable("id") Long id, @RequestBody TaskDTO taskDTO){
        return taskService.updateTask(id, taskDTO);
    }

    @DeleteMapping("{id}")
    public void deleteTask(@PathVariable("id") Long id){
        taskService.deleteTask(id);

    }

}
