package Task;
import Exception.IncorrectArgumentException;

import java.time.LocalDate;

public class WeeklyTask extends Task{
    public WeeklyTask(String title, Type type, String description) throws IncorrectArgumentException {
        super(title, type, description);
    }

    @Override
    public LocalDate getNextTimeTask(LocalDate localDate) {
        return localDate.plusWeeks(1);
    }
}
