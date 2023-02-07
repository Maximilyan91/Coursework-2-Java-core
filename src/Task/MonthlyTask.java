package Task;
import Exception.IncorrectArgumentException;
public class MonthlyTask extends Task{
    public MonthlyTask(String title, Type type, String description) throws IncorrectArgumentException {
        super(title, type, description);
    }
}
