package com.felipe.task.management.modules.task;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/task")
public class TaskController {
    @Autowired
    private TaskService taskService;

   @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TaskEntity> read() {
        return taskService.read();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public TaskEntity fingById(@PathVariable(value = "id") Long id) {
        return taskService.findById(id);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public TaskEntity create(@RequestBody TaskEntity payload) {
        return taskService.create(payload);
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public TaskEntity update(@RequestBody TaskEntity payload) {
        return taskService.update(payload);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable(value = "id") Long id) {
        taskService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
