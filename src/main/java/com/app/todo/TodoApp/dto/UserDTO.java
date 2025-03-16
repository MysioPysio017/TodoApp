package com.app.todo.TodoApp.dto;

import com.app.todo.TodoApp.enums.Role;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Long id;

    @NotNull
    @Size(min = 2, message = "Your name needs at least 2 characters")
    private String name;

    @NotNull
    @Email
    private String email;

    @NotNull
    @Size(min = 8, message = "Your password must contain at least 8 characters")
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role = Role.ROLE_USER;

    private List<TaskDTO> tasks = new ArrayList<>();
}