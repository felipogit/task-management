package com.felipe.task.management.modules.task;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipe.task.management.mapper.DozerMapper;
import com.felipe.task.management.modules.task.dtos.TaskCreateDTO;
import com.felipe.task.management.modules.task.exceptions.costumExceptions.ResourseNotFoundException;


@Service
public class TaskService {

    private Logger logger = Logger.getLogger(TaskService.class.getName());

    @Autowired
    private TaskRepository taskRepository;

    public List<TaskCreateDTO> read() {
        logger.info("Find all tasks!");
        return DozerMapper.parseListObjects(taskRepository.findAll(), TaskCreateDTO.class);
    }

    public TaskCreateDTO findById(Long id) {
        logger.info("Find task by id: " + id);
        var task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourseNotFoundException("Task not found!"));
        return DozerMapper.parseObject(task, TaskCreateDTO.class);
    }
        
    public TaskCreateDTO create(TaskCreateDTO payload) {
        logger.info("Create new task!");
        var entity = DozerMapper.parseObject(payload, TaskEntity.class);
        var vo = DozerMapper.parseObject(taskRepository.save(entity), TaskCreateDTO.class);
        return vo;
    }

    public TaskCreateDTO update(TaskCreateDTO task) {
        logger.info("Update task by id: " + task.getId());

        var entity = taskRepository.findById(task.getId())
            .orElseThrow(() -> new ResourseNotFoundException("Task not found!"));

        entity.setTitle(task.getTitle());
        entity.setStatus(task.getStatus());
        entity.setDescription(task.getDescription());

        var vo = DozerMapper.parseObject(taskRepository.save(entity), TaskCreateDTO.class);
        return vo;
    }


    public void delete(Long id) {
        logger.info("Delete task by id: " + id);

        var entity = taskRepository.findById(id)
            .orElseThrow(() -> new ResourseNotFoundException("Task not found!"));
        
        taskRepository.delete(entity);
    }
}
