package com.app.todo.TodoApp.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Long id) {
        super("User with the id: " + id + " could not be found");
    }

    public UserNotFoundException(String email){
        super("User with the email: " + email + " could not be found");
    }
}
