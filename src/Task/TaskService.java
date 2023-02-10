package Task;

import Exception.TaskNotFoundException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
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

    public Collection<Task> getAllByDate(LocalDate date) {
        Collection<Task> taskOnDay = new ArrayList<>();

        for (Task task : taskMap.values()) {
            LocalDateTime taskTime = task.getDateTime();
            LocalDateTime taskNextTime = task.getNextTimeTask(taskTime);

            if (taskNextTime == null || taskTime.toLocalDate().equals(date)) {
                taskOnDay.add(task);
                continue;
            }

            do {
                if (taskNextTime.toLocalDate().equals(date)) {
                    taskOnDay.add(task);
                    break;
                }

                taskNextTime = task.getNextTimeTask(taskNextTime);
            } while (taskNextTime.toLocalDate().isBefore(date));
        }
        return taskOnDay;
    }

}





