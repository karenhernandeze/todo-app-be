package karenhernandeze.demo.service;

import java.util.List;
import karenhernandeze.demo.model.Task;

public interface TaskService {
    public List<Task> getAllTasks();
    public Task createTask(Task task);
}
