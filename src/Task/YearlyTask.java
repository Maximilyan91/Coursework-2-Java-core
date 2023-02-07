package Task;
import Exception.IncorrectArgumentException;

public class YearlyTask extends Task{
    public YearlyTask(String title, Type type, String description) throws IncorrectArgumentException {
        super(title, type, description);
    }
}
