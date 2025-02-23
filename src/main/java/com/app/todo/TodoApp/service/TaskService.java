package com.app.todo.TodoApp.service;

import com.app.todo.TodoApp.entity.Task;

import java.util.List;

public interface TaskService {

List<Task> getTasks();

Task saveTask(Task task);

Task updateTask(Long id, Task task);

void deleteTask(Long id);
}
