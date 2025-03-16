package com.app.todo.TodoApp.service;

import com.app.todo.TodoApp.dto.UserDTO;
import com.app.todo.TodoApp.entity.User;
import com.app.todo.TodoApp.exception.UserNotFoundException;
import com.app.todo.TodoApp.mapper.UserMapper;
import com.app.todo.TodoApp.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    UserServiceImpl(UserRepository userRepository, UserMapper userMapper){
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream().map(userMapper::toUserDTO).toList();
    }

    @Override
    public UserDTO getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        return userMapper.toUserDTO(user);
    }

    @Override
    public UserDTO getUserByEmail(String email) {
        User user = userRepository.findByEmail(email);
        if (user == null){
            throw new UserNotFoundException(email);
        }
        return userMapper.toUserDTO(user);
    }

    @Override
    public void addUser(UserDTO userDTO) {
        User user = userMapper.toUser(userDTO);
        userRepository.save(user);
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }
}
