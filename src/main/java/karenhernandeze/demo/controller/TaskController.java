package karenhernandeze.demo.controller;

import java.util.List;
import java.util.NoSuchElementException;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.bind.annotation.CrossOrigin;

import karenhernandeze.demo.exception.TaskNotFoundException;
import karenhernandeze.demo.model.Filters;
import karenhernandeze.demo.model.Task;
import karenhernandeze.demo.service.TaskService;

@CrossOrigin(origins = {"http://localhost:8080", "http://192.168.1.189:8080"})
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

    @PostMapping("/todos/filter")
    public ResponseEntity<List<Task>> filterTasks(@Valid @RequestBody Filters f) {
        try {
            List<Task> tasks = taskService.filterTasks(f);
            return ResponseEntity.ok(tasks);
        } catch (TaskNotFoundException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Task Not Found.", e);
        }
    }

    @DeleteMapping("/todos/{id}")
    public ResponseEntity<String> deleteItem(@Valid @PathVariable("id") long id) {
        try {
            taskService.deleteTask(id);
            return ResponseEntity.ok("Item deleted successfully");
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Item not found");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred");
        }
    }

    @GetMapping("/todos/sortdes")
    public ResponseEntity<List<Task>> getTasksSortedByDateDES() {
        List<Task> tasks = taskService.getAllTasksSortedDES();
        return ResponseEntity.ok(tasks);
    }

    @GetMapping("/todos/sortasc")
    public ResponseEntity<List<Task>> getTasksSortedByDateASC() {
        List<Task> tasks = taskService.getAllTasksSortedASC();
        return ResponseEntity.ok(tasks);
    }

    @GetMapping("/todos/sort-priorityasc")
    public ResponseEntity<List<Task>> getTasksSortedByPriorityASC() {
        List<Task> tasks = taskService.getAllTasksSortedByPriorityASC();
        return ResponseEntity.ok(tasks);
    }

    @GetMapping("/todos/sort-prioritydes")
    public ResponseEntity<List<Task>> getTasksSortedByPriorityDES() {
        List<Task> tasks = taskService.getAllTasksSortedByPriorityDES();
        return ResponseEntity.ok(tasks);
    }

}