package Task;
import java.time.LocalDateTime;

public interface Repeatable {
    LocalDateTime getNextTimeTask(LocalDateTime localDateTime);

}
