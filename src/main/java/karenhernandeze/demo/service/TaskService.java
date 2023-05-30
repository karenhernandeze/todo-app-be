package karenhernandeze.demo.service;

import java.util.List;

import karenhernandeze.demo.model.Filters;
import karenhernandeze.demo.model.Task;

public interface TaskService {
    public List<Task> getAllTasks();
    public Task createTask(Task task);
    public Task updateTask(Task task, Long id);
    public Task markTaskDone(Task task, Long id); 
    public Task markTaskUndone(Long id); 
    public List<Task> filterTasks(Filters f); 
    public void deleteTask(Long id);
    public List<Task> getAllTasksSortedASC();
    public List<Task> getAllTasksSortedDES();
    public List<Task> getAllTasksSortedByPriorityASC();
    public List<Task> getAllTasksSortedByPriorityDES();
    // public long averageTime();
}
