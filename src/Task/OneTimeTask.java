package Task;
import Exception.IncorrectArgumentException;
public class OneTimeTask extends Task{
    public OneTimeTask(String title, Type type, String description) throws IncorrectArgumentException {
        super(title, type, description);
    }
}
