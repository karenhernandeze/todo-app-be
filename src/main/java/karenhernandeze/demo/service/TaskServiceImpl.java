package karenhernandeze.demo.service;

import karenhernandeze.demo.exception.TaskNotFoundException;
import karenhernandeze.demo.model.Task;
import karenhernandeze.demo.repository.TaskRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {
    // temporary data storage
    List<Task> list;

    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task updateTask(Task task, Long id) {

        Optional<Task> existingTask = taskRepository.findById(id);

        if (existingTask.isEmpty()) {
            throw new TaskNotFoundException("id: " + id);
        }

        Task _task = existingTask.get();
        _task.setText(task.getText());
        _task.setCreationDate(task.getCreationDate());
        _task.setDone(task.getDone());
        _task.setDoneDate(task.getDoneDate());
        _task.setDueDate(task.getDueDate());
        _task.setPriority(task.getPriority());
        taskRepository.save(_task);

        return _task;
    }

    @Override
    public Task markTaskDone(Task task, Long id) {
        Optional<Task> getTask = taskRepository.findById(id);

        Task _task = getTask.get();
        _task.setDone(true);
        _task.setDoneDate(task.getDoneDate());
        taskRepository.save(_task);

        return _task;
    }

    @Override
    public Task markTaskUndone(Long id) {
        Optional<Task> getTask = taskRepository.findById(id);

        Task _task = getTask.get();
        _task.setDone(false);
        _task.setDoneDate(null);
        taskRepository.save(_task);

        return _task;
    }
}
