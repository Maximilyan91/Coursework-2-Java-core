package Task;
import Exception.IncorrectArgumentException;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class YearlyTask extends Task{
    public YearlyTask(String title, Type type, String description, LocalDateTime taskTime) throws IncorrectArgumentException {
        super(title, type, description, taskTime);
    }


    @Override
    public LocalDate getNextDateTask(LocalDate localDate) {
        return localDate.plusYears(1);
    }
}
