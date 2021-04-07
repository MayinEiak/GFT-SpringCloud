package com.ms.persistence.persistence.controller;

import com.ms.persistence.persistence.entity.Task;
import com.ms.persistence.persistence.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.HashMap;
import java.util.Optional;


@RestController
@RequestMapping("tasks")
class TaskController {

   TaskRepository taskRepository;

   @Autowired
   public TaskController (TaskRepository taskRepository){
       this.taskRepository = taskRepository;
   }


    @PutMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> updateTaskById(@PathVariable Long id, @RequestBody Task taskEntity){
        taskEntity.setId(id);

        if (taskEntity.getDescription() == null || taskEntity.getDescription().equals("")){
            return new ResponseEntity(new HashMap<String, Object>() {{
                put("message", "Task description is required");
                put("status", HttpStatus.BAD_REQUEST.value());
            }}, HttpStatus.BAD_REQUEST);
        }


        Optional<Task> opt = taskRepository.findById(id);
        if (!opt.isPresent()){
            return new ResponseEntity(new HashMap<String, Object>() {{
                put("message", "Cannot find task with given id");
                put("status", HttpStatus.NOT_FOUND.value());
            }}, HttpStatus.NOT_FOUND);
        }


        taskRepository.save(taskEntity);
        return new ResponseEntity(taskEntity, HttpStatus.OK);
    }
}


