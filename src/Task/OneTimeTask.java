package Task;
import Exception.IncorrectArgumentException;
import Exception.TaskNotFoundException;

import java.time.LocalDateTime;

public class OneTimeTask extends Task{

    public OneTimeTask(String title, Type type, String description, LocalDateTime taskTime) throws IncorrectArgumentException, TaskNotFoundException {
        super(title, type, description, taskTime);
    }

    @Override
    public LocalDateTime getNextTimeTask(LocalDateTime localDateTime) {
        return localDateTime;
    }
}
