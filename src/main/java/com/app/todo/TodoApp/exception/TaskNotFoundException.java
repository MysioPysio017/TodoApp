package com.app.todo.TodoApp.exception;

public class TaskNotFoundException extends RuntimeException{
    public TaskNotFoundException(Long id){
        super("Task with the id: " + id + " could not be found");
    }
}
