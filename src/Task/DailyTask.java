package Task;
import Exception.IncorrectArgumentException;

import java.time.LocalDate;

public class DailyTask extends Task{

    public DailyTask(String title, Type type, String description) throws IncorrectArgumentException {
        super(title, type, description);
    }

    @Override
    public LocalDate getNextTimeTask(LocalDate localDate) {
        return localDate.plusDays(1);
    }
}
