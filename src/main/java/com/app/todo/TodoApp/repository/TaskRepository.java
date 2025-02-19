package com.app.todo.TodoApp.repository;

import com.app.todo.TodoApp.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
