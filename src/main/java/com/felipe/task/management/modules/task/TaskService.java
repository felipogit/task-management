package com.felipe.task.management.modules.task;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public TaskEntity create(TaskEntity payload) {
        var task = taskRepository.save(payload);
        return task;
    }

    public List<TaskEntity> read() {
        return taskRepository.findAll();
    }
}
