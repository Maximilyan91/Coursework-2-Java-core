package Task;

import Exception.TaskNotFoundException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class TaskService {
    public Map<Integer, Task> taskMap = new HashMap<>();

    public void addTask(Task task) {
        taskMap.put(task.getId(), task);
    }

    public void removeTask(Integer id) throws TaskNotFoundException {
        if (this.taskMap.containsKey(id)) {
            this.taskMap.remove(id);
        } else {
            throw new TaskNotFoundException(id);
        }
    }

    public void getAllTasks() {
        System.out.println(taskMap.values());
    }

    public Collection<Task> getAllByDate(LocalDate date) {
        Collection<Task> tasksByDay = new ArrayList<>();
        Collection<Task> allTasks = taskMap.values();

        for (Task task : allTasks) {
            LocalDateTime currentDateTime = task.getTaskTime();

            if (currentDateTime.toLocalDate().equals(date)) {
                tasksByDay.add(task);
                break;
            }
            LocalDateTime taskNextTime = currentDateTime;

            do {
                taskNextTime = task.getNextTimeTask(taskNextTime);

                if (taskNextTime == null) {
                    break;
                }

                if (taskNextTime.toLocalDate().equals(date)) {
                    tasksByDay.add(task);
                break;
                }
            } while (taskNextTime.toLocalDate().isBefore(date));
        }
        return tasksByDay;
    }
}





