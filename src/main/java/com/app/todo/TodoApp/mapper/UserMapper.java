package com.app.todo.TodoApp.mapper;

import com.app.todo.TodoApp.dto.UserDTO;
import com.app.todo.TodoApp.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserDTO userDTO);
    UserDTO toUserDTO(User user);
}
