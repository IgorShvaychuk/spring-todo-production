package com.example.repository;

import com.example.model.Task;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Profile("test")
public class InMemoryTaskRepository implements TaskRepository {
    private final List<Task> tasks = new ArrayList<>();
    private long idCounter = 1;

    @Override
    public List<Task> findAll() {
        return tasks;
    }

    @Override
    public void save(String description) {
        tasks.add(new Task(idCounter++, description, "Local Temporary RAM"));
    }
}
