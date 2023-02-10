package Task;

import Exception.IncorrectArgumentException;

import java.time.LocalDateTime;

public class DailyTask extends Task{

    public DailyTask(String title, Type type, String description, LocalDateTime taskTime) throws IncorrectArgumentException {
        super(title, type, description, taskTime);
    }

    @Override
    public LocalDateTime getNextTimeTask(LocalDateTime localDateTime) {
        return localDateTime.plusDays(1);
    }
}
