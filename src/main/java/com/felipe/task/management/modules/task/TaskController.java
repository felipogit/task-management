package com.felipe.task.management.modules.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/task")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody TaskEntity payload) {
        var task = taskService.create(payload);
        return ResponseEntity.status(201).body(task);
    }

    @GetMapping
    public ResponseEntity<?> read() {
        var tasks = taskService.read();
        return ResponseEntity.status(200).body(tasks);
    }
}
