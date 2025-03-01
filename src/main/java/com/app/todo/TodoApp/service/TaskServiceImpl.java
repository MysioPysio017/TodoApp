package com.app.todo.TodoApp.service;

import com.app.todo.TodoApp.dto.TaskDTO;
import com.app.todo.TodoApp.entity.Task;
import com.app.todo.TodoApp.exception.TaskNotFoundException;
import com.app.todo.TodoApp.mapper.TaskMapper;
import com.app.todo.TodoApp.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class TaskServiceImpl implements TaskService{
    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    @Autowired
    TaskServiceImpl(TaskRepository taskRepository, TaskMapper taskMapper){
        this.taskRepository = taskRepository;
        this.taskMapper = taskMapper;
    }

    @Override
    public List<TaskDTO> getTasks() {
        return taskRepository.findAll().stream()
                .map(taskMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public TaskDTO saveTask(TaskDTO taskDTO) {
        Task task = taskMapper.toEntity(taskDTO);
        return taskMapper.toDTO(taskRepository.save(task));
    }

    @Override
    public TaskDTO updateTask(Long id, TaskDTO taskDTO) {
        Task task = taskMapper.toEntity(taskDTO);
        Task updateTask = taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException(id));
        updateTask.setTitle(task.getTitle());
        updateTask.setBody(task.getBody());
        updateTask.setDueDate(task.getDueDate());
        updateTask.setCompleted(task.isCompleted());
        return taskMapper.toDTO(taskRepository.save(updateTask));
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}
