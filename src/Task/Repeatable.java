package Task;
import java.time.LocalDate;
import java.time.LocalDateTime;

public interface Repeatable {
    LocalDate getNextDateTask(LocalDate localDate);

}
