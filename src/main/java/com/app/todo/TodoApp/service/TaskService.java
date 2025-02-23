package com.app.todo.TodoApp.service;

import com.app.todo.TodoApp.dto.TaskDTO;
import java.util.List;

public interface TaskService {
    List<TaskDTO> getTasks();
    TaskDTO saveTask(TaskDTO taskDTO);
    TaskDTO updateTask(Long id, TaskDTO taskDTO);
    void deleteTask(Long id);
}
