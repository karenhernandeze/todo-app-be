package karenhernandeze.demo.service;

import karenhernandeze.demo.exception.TaskNotFoundException;
import karenhernandeze.demo.model.Filters;
import karenhernandeze.demo.model.Task;
import karenhernandeze.demo.repository.TaskRepository;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {
    // temporary data storage
    List<Task> list = new ArrayList<>();
    List<Task> doneTasks = new ArrayList<>();
    List<Task> doneTasks1 = new ArrayList<>();
    List<Task> doneTasks2 = new ArrayList<>();
    List<Task> doneTasks3 = new ArrayList<>();

    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
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
        LocalDateTime doneDate = LocalDateTime.now();
        LocalDateTime trimmedDate = doneDate.truncatedTo(ChronoUnit.SECONDS);

        Task _task = getTask.get();
        _task.setDone(true);
        _task.setDoneDate(trimmedDate);
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

    @Override
    public List<Task> filterTasks(Filters f) {
        List<Task> listFilter;
        listFilter = taskRepository.findByDoneAndPriorityAndTextContaining(f.getDone(), f.getPriority(), f.getText());
        return listFilter;
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    @Override
    public List<Task> getAllTasksSortedASC() {
        return taskRepository.findAllByOrderByDueDateAsc();
    }

    @Override
    public List<Task> getAllTasksSortedDES() {
        return taskRepository.findAllByOrderByDueDateDesc();
    }

    @Override
    public List<Task> getAllTasksSortedByPriorityASC() {
        return taskRepository.findAllByOrderByPriorityAsc(null);
    }

    @Override
    public List<Task> getAllTasksSortedByPriorityDES() {
        return taskRepository.findAllByOrderByPriorityDesc(null);
    }

    @Override
    public Long averageTime() {
        List<Task> allTasks = taskRepository.findAll();
        for (Task task : allTasks) {
            if ((task.getCreationDate() != null) && (task.getDoneDate() != null)) {
                System.out.println("CREATION "+task.getCreationDate());
                System.out.println("DONE "+task.getDoneDate());
                doneTasks.add(task);
            }
        }
        Duration totalDuration = Duration.ZERO;
        for (Task task : doneTasks) {
            LocalDateTime createdDate = task.getCreationDate();
            LocalDateTime doneDate = task.getDoneDate();
            Duration duration = Duration.between(createdDate, doneDate);
            totalDuration = totalDuration.plus(duration);
        }
        Long averageTime = totalDuration.toMinutes() / doneTasks.size();
        return averageTime;
    }

    @Override
    public Long averageTimeLow() {
        List<Task> allTasks = taskRepository.findAll();
        for (Task task : allTasks) {
            if ((task.getCreationDate() != null) && (task.getDoneDate() != null) && (task.getPriority() == "low")) {
                System.out.println("CREATION "+task.getCreationDate());
                System.out.println("DONE "+task.getDoneDate());
                doneTasks1.add(task);
            }
        }
        Duration totalDuration = Duration.ZERO;
        for (Task task : doneTasks1) {
            LocalDateTime createdDate = task.getCreationDate();
            LocalDateTime doneDate = task.getDoneDate();
            Duration duration = Duration.between(createdDate, doneDate);
            totalDuration = totalDuration.plus(duration);
        }
        Long averageTime = totalDuration.toMinutes() / doneTasks1.size();
        return averageTime;
    }

    @Override
    public Long averageTimeMedium() {
        List<Task> allTasks = taskRepository.findAll();
        for (Task task : allTasks) {
            if ((task.getCreationDate() != null) && (task.getDoneDate() != null)  && (task.getPriority() == "medium")) {
                System.out.println("CREATION "+task.getCreationDate());
                System.out.println("DONE "+task.getDoneDate());
                doneTasks2.add(task);
            }
        }
        Duration totalDuration = Duration.ZERO;
        for (Task task : doneTasks2) {
            LocalDateTime createdDate = task.getCreationDate();
            LocalDateTime doneDate = task.getDoneDate();
            Duration duration = Duration.between(createdDate, doneDate);
            totalDuration = totalDuration.plus(duration);
        }
        Long averageTime = totalDuration.toMinutes() / doneTasks2.size();
        return averageTime;
    }

    @Override
    public Long averageTimeHigh() {
        List<Task> allTasks = taskRepository.findAll();
        for (Task task : allTasks) {
            if ((task.getCreationDate() != null) && (task.getDoneDate() != null) && (task.getPriority() == "high")) {
                doneTasks3.add(task);
            }
        }
        Duration totalDuration = Duration.ZERO;
        for (Task task : doneTasks3) {
            LocalDateTime createdDate = task.getCreationDate();
            LocalDateTime doneDate = task.getDoneDate();
            Duration duration = Duration.between(createdDate, doneDate);
            totalDuration = totalDuration.plus(duration);
        }
        Long averageTime = totalDuration.toMinutes() / doneTasks3.size();
        return averageTime;
    }
}
