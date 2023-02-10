package Task;
import Exception.IncorrectArgumentException;

import java.time.LocalDate;

public class MonthlyTask extends Task{
    public MonthlyTask(String title, Type type, String description) throws IncorrectArgumentException {
        super(title, type, description);
    }

    @Override
    public LocalDate getNextTimeTask(LocalDate localDate) {
        return localDate.plusMonths(1);
    }
}
