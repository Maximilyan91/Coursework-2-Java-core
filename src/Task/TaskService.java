package Task;

import Exception.TaskNotFoundException;
import java.util.HashMap;
import java.util.Map;

public class TaskService {
    private final Map<Integer, Task> taskMap = new HashMap<>();

    public void addTask(Task task) {
        this.taskMap.put(task.getId(), task);
    }

    public void removeTask(Integer id) throws TaskNotFoundException {
        if (this.taskMap.containsKey(id)) {
            this.taskMap.remove(id);
        } else {
            throw new TaskNotFoundException(id);
        }

    }

}





