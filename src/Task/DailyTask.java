package Task;
import Exception.IncorrectArgumentException;

public class DailyTask extends Task{

    public DailyTask(String title, Type type, String description) throws IncorrectArgumentException {
        super(title, type, description);
    }
}
