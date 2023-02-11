package Task;

import Exception.TaskNotFoundException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class TaskService {
    private Map<Integer, Task> taskMap = new HashMap<>(10);

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
        Collection<Task> tasksByDay = new ArrayList<>();
        Collection<Task> allTasks = taskMap.values();

        for (Task task : allTasks) {
            LocalDateTime currentDateTime = task.getDateTime();

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





