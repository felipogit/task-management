package com.felipe.task.management.modules.task.dtos;

import java.io.Serializable;

import lombok.Data;

@Data
public class TaskCreateDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String title;
    private String status;
    private String description;
}
