package com.app.todo.TodoApp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String body;

    /*
    * @CreationTimestamp automatically puts the created date in createdAt variable.
    * We can also use @UpdateTimestamp to get updated modification date. */
    @CreationTimestamp
    private LocalDateTime createdAt;
    private LocalDateTime dueDate;

    private boolean completed;
}
