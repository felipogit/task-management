package com.felipe.task.management.modules.task;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipe.task.management.modules.task.exceptions.costumExceptions.ResourseNotFoundException;


@Service
public class TaskService {

    private Logger logger = Logger.getLogger(TaskService.class.getName());

    @Autowired
    private TaskRepository taskRepository;

    public List<TaskEntity> read() {
        logger.info("Find all tasks!");
        return taskRepository.findAll();
    }

    public TaskEntity findById(Long id) {
        logger.info("Find task by id: " + id);
        return taskRepository.findById(id)
            .orElseThrow(() -> new ResourseNotFoundException("Task not found!"));
    }
    

    public TaskEntity create(TaskEntity payload) {
        var task = taskRepository.save(payload);
        return task;
    }

    public TaskEntity update(TaskEntity task) {
        logger.info("Update task by id: " + task.getId());

        var entity = taskRepository.findById(task.getId())
            .orElseThrow(() -> new ResourseNotFoundException("Task not found!"));

        entity.setTitle(task.getTitle());
        entity.setStatus(task.getStatus());
        entity.setDescription(task.getDescription());

        return taskRepository.save(entity);
    }


    public void delete(Long id) {
        logger.info("Delete task by id: " + id);

        var entity = taskRepository.findById(id)
            .orElseThrow(() -> new ResourseNotFoundException("Task not found!"));
        
        taskRepository.delete(entity);
    }
}
