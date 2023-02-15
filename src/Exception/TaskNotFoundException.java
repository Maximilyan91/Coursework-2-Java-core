package Exception;

public class TaskNotFoundException extends Exception {

    public TaskNotFoundException(Integer id) {
        super("Задача № - " + id + " не найдена");
    }
}
