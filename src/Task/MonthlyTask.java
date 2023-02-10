package Task;
import Exception.IncorrectArgumentException;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class MonthlyTask extends Task{

    public MonthlyTask(String title, Type type, String description, LocalDateTime taskTime) throws IncorrectArgumentException {
        super(title, type, description, taskTime);
    }

    @Override
    public LocalDateTime getNextTimeTask(LocalDateTime localDateTime) {
        return localDateTime.plusMonths(1);
    }
}
