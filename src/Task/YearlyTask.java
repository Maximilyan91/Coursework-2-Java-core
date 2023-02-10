package Task;
import Exception.IncorrectArgumentException;

import java.time.LocalDate;

public class YearlyTask extends Task{
    public YearlyTask(String title, Type type, String description) throws IncorrectArgumentException {
        super(title, type, description);
    }

    @Override
    public LocalDate getNextTimeTask(LocalDate localDate) {
        return localDate.plusYears(1);
    }
}
