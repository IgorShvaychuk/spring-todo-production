package com.example.repository;

import com.example.model.Task;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
@Profile("prod")
public class JdbcTaskRepository implements TaskRepository {
    private final JdbcTemplate jdbc;

    public JdbcTaskRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
        this.jdbc.execute("CREATE TABLE IF NOT EXISTS tasks (id VARCHAR(255), description VARCHAR(255))");
    }

    @Override
    public List<Task> findAll() {
        return jdbc.query("SELECT * FROM tasks", (rs, rowNum) ->
                new Task(rs.getString("id"), rs.getString("description"), "PostgreSQL (PROD)")
        );
    }

    @Override
    public void save(String description) {
        jdbc.update("INSERT INTO tasks (id, description) VALUES (?, ?)",
                UUID.randomUUID().toString(), description);
    }
}
