package com.app.todo.TodoApp.service;

import com.app.todo.TodoApp.dto.UserDTO;
import com.app.todo.TodoApp.entity.User;

import java.util.List;

public interface UserService{

    List<UserDTO> getAllUsers();
    UserDTO getUserById(Long id);
    UserDTO getUserByEmail(String email);
    void addUser(UserDTO userDTO);
    void deleteUserById(Long id);
}
