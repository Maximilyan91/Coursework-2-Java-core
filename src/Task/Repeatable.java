package Task;

import java.time.LocalDate;

public interface Repeatable {
    LocalDate getNextTimeTask(LocalDate localDate);

}
