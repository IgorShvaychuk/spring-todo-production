package com.example.repository;

import com.example.model.Task;

import java.util.List;

public interface TaskRepository {
    List<Task> findAll();
    void save(String description);
}
