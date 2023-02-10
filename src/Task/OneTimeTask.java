package Task;
import Exception.IncorrectArgumentException;

import java.time.LocalDate;

public class OneTimeTask extends Task{
    public OneTimeTask(String title, Type type, String description) throws IncorrectArgumentException {
        super(title, type, description);
    }

    @Override
    public LocalDate getNextTimeTask(LocalDate localDate) {
        return null;
    }
}
