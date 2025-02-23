package com.app.todo.TodoApp.mapper;

import com.app.todo.TodoApp.dto.TaskDTO;
import com.app.todo.TodoApp.entity.Task;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TaskMapper {
    Task toEntity(TaskDTO taskDTO);
    TaskDTO toDTO(Task task);
}