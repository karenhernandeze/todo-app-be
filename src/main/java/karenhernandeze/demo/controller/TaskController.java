package karenhernandeze.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import karenhernandeze.demo.exception.TaskNotFoundException;
import karenhernandeze.demo.model.Task;
import karenhernandeze.demo.service.TaskService;

@RestController
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/")
    public String test() {
        return "api is working fine";
    }

    @GetMapping("/todos")
    public ResponseEntity<List<Task>> getAllTasks() {
        List<Task> tasks = taskService.getAllTasks();
        return ResponseEntity.ok(tasks);
    }

    @PostMapping("/todos")
    public ResponseEntity<Task> createTask(@Valid @RequestBody Task task) {
        Task createdTask = taskService.createTask(task);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTask);
    }

    @PutMapping("/todos/{id}")
    public ResponseEntity<Task> updateTask(@Valid @PathVariable("id") long id, @RequestBody Task task) {
        try {
            Task updatedTask = taskService.updateTask(task, id);
            return ResponseEntity.status(HttpStatus.OK).body(updatedTask);
        } catch (TaskNotFoundException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Task Not Found.", e);
        }
    }

    @PostMapping("/todos/{id}/done")
    public ResponseEntity<Task> markTaskDone(@Valid @PathVariable("id") long id, @RequestBody Task task) {
        try {
            Task taskUpdated = taskService.markTaskDone(task, id);
            return ResponseEntity.status(HttpStatus.OK).body(taskUpdated);
        } catch (TaskNotFoundException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Task Not Found.", e);
        } 
    }

    @PutMapping("/todos/{id}/undone")
    public ResponseEntity<Task> markTaskUndone(@Valid @PathVariable("id") long id) {
        try {
            Task taskUpdatedUndone = taskService.markTaskUndone(id);
            return ResponseEntity.status(HttpStatus.OK).body(taskUpdatedUndone);
        } catch (TaskNotFoundException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Task Not Found.", e);
        }
    }
}