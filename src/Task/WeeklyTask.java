package Task;
import Exception.IncorrectArgumentException;
public class WeeklyTask extends Task{
    public WeeklyTask(String title, Type type, String description) throws IncorrectArgumentException {
        super(title, type, description);
    }
}
