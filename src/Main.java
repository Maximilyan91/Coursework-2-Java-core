import Task.OneTimeTask;
import Task.DailyTask;
import Task.WeeklyTask;
import Task.MonthlyTask;
import Task.TaskService;
import Task.YearlyTask;
import Task.Task;
import Task.Type;
import Exception.TaskNotFoundException;
import Exception.IncorrectArgumentException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Pattern;



public class Main {

    private static final TaskService taskService = new TaskService();

    private static final Pattern DATE_TIME_PATTERN = Pattern.compile("\\d{2}\\.\\d{2}\\.\\d{4} \\d{2}\\:\\d{2}");
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("DD.MM.YYYY HH:MM");
    public static void main(String[] args) throws TaskNotFoundException, IncorrectArgumentException {

        try (Scanner scanner = new Scanner(System.in)){
            label:
            while (true) {
                printMenu();
                System.out.println("Выберите пункт меню: ");
                if (scanner.hasNextInt()) {
                    int menu = scanner.nextInt();
                    switch (menu) {
                        case 1:
                            inputTask(scanner);
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                        case 0:
                            break label;
                    }
                } else {
                    scanner.next();
                    System.out.println("Выберите пункт из списка");
                }
            }
        }
    }

    private static void inputTask(Scanner scanner) throws TaskNotFoundException, IncorrectArgumentException {
        System.out.println("Введите название задачи: ");
        String title = scanner.next();

        System.out.println("Введите описание задачи: ");
        String description = scanner.next();

        System.out.println("Введите тип задачи (1 - личная, 2 - рабочая) ");
        Type type = null;

        int taskTypeChoice = scanner.nextInt();

        if (taskTypeChoice == 1) {
            type = Type.PERSONAL;
        } else if (taskTypeChoice == 2) {
            type = Type.WORK;
        } else {
            scanner.next();
            System.out.println("Введено некорректное число");
        }
        System.out.println("Введите дату и время задачи в формате DD.MM.YYYY HH:MM");

        LocalDateTime taskTime = null;
        if (scanner.hasNextInt()) {
            String dateTime = scanner.next(DATE_TIME_PATTERN);
            taskTime = LocalDateTime.parse(dateTime, DATE_TIME_FORMATTER);
        }

        if (taskTime == null) {
            System.out.println("Введите дату и время задачи в формате DD.MM.YYYY HH:MM");
            scanner.close();
        }

        System.out.println("Введите повторяемость задачи: 1 - однократная, 2 - ежедневная, " +
                "3 - каждую неделю, 4 - каждый месяц, 5 - каждый год");

        Task task = null;

        if (scanner.hasNextInt()) {
            int repeatability = scanner.nextInt();

            switch (repeatability) {
                case 1:
                    task = new OneTimeTask(title, type, description, taskTime);
                case 2:
                    task = new DailyTask(title, type, description, taskTime);
                case 3:
                    task = new WeeklyTask(title, type, description, taskTime);
                case 4:
                    task = new MonthlyTask(title, type, description, taskTime);
                case 5:
                    task = new YearlyTask(title, type, description, taskTime);
            }
        }

        taskService.addTask(task);
        System.out.println("Задача добавлена");
    }
    private static void printMenu() {
        System.out.println("1. Добавить задачу\n2. Удалить задачу\n3. Получить задачу на указанный день\n6. Выход");
    }
}