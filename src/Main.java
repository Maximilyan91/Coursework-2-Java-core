import Task.OneTimeTask;
import Task.DailyTask;
import Task.WeeklyTask;
import Task.MonthlyTask;
import Task.TaskService;
import Task.YearlyTask;
import Task.Task;
import Task.Type;
import Exception.IncorrectArgumentException;
import Exception.TaskNotFoundException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.Scanner;
import java.util.regex.Pattern;



public class Main {

    private static final TaskService TASK_SERVICE = new TaskService();

    private static final Pattern DATE_TIME_PATTERN = Pattern.compile("\\d{2}\\.\\d{2}\\.\\d{4} \\d{2}\\:\\d{2}");
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
    private static final Pattern DATE_PATTERN = Pattern.compile("\\d{2}\\.\\d{2}\\.\\d{4}");
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    public static void main(String[] args) {

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
                            removeTask(scanner);
                            break;
                        case 3:
                            printTasksByDate(scanner);
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

    private static void inputTask(Scanner scanner) {
        scanner.useDelimiter("\n");

        String title = inputTaskTitle(scanner);
        String description = inputTaskDescription(scanner);
        Type type = inputTaskType(scanner);
        LocalDateTime taskTime = inputTaskTime(scanner);
        int repeatability = inputRepeatability(scanner);

        createTask(title, description, type,taskTime, repeatability);


    }

    private static void createTask(String title, String description, Type type, LocalDateTime taskTime, int repeatability) {
        Task task = null;
        try {
            switch (repeatability) {
                case 1:
                    task = new OneTimeTask(title, type, description, taskTime);
                    break;
                case 2:
                    task = new DailyTask(title, type, description, taskTime);
                    break;
                case 3:
                    task = new WeeklyTask(title, type, description, taskTime);
                    break;
                case 4:
                    task = new MonthlyTask(title, type, description, taskTime);
                    break;
                case 5:
                    task = new YearlyTask(title, type, description, taskTime);
                    break;
            }
        } catch (IncorrectArgumentException e) {
            System.out.println(e.getMessage());
        }

        if (task != null) {
            TASK_SERVICE.addTask(task);
            System.out.println("Задача добавлена");
        } else {
            System.out.println("Введены некорректные данные по задаче");
        }
    }

    public static void removeTask(Scanner scanner) {
        System.out.println("Введите номер задачи, которую хотите удалить");
        int id = scanner.nextInt();

        try {
            TASK_SERVICE.removeTask(id);
        } catch (TaskNotFoundException e) {
            System.out.println(e.getMessage());

        }
    }

    private static String inputTaskTitle(Scanner scanner) {
        System.out.println("Введите название задачи: ");
        String title = scanner.next();

        if (title.isBlank() || title.isEmpty()) {
            System.out.println("Введено некорректное название задачи");
        }
        return title;
    }

    private static String inputTaskDescription(Scanner scanner) {
        System.out.println("Введите описание задачи: ");
        String title = scanner.next();

        if (title.isBlank() || title.isEmpty()) {
            System.out.println("Введено некорректное описание задачи");
            scanner.close();
        }
        return title;
    }
    private static Type inputTaskType(Scanner scanner) {
        System.out.println("Введите тип задачи (1 - личная, 2 - рабочая) ");
        Type type = null;

        int taskTypeChoice = scanner.nextInt();

        switch (taskTypeChoice) {
            case 1:
                type = Type.PERSONAL;
                break;
            case 2:
                type = Type.WORK;
                break;
            default:
                System.out.println("Тип задачи указан неверно");
        }
        return type;
    }

    private static LocalDateTime inputTaskTime(Scanner scanner) {
        System.out.println("Введите дату и время задачи в формате DD.MM.YYYY HH:MM");

        if (scanner.hasNext(DATE_TIME_PATTERN)) {
            String dateTime = scanner.next(DATE_TIME_PATTERN);
            return LocalDateTime.parse(dateTime, DATE_TIME_FORMATTER);
        } else {
            System.out.println("Введите дату и время задачи в формате DD.MM.YYYY HH:MM");
            scanner.close();
            return null;
        }
    }

    private static int inputRepeatability(Scanner scanner) {
        System.out.println("Введите повторяемость задачи: 1 - однократная, 2 - ежедневная, " +
                "3 - каждую неделю, 4 - каждый месяц, 5 - каждый год");
        if (scanner.hasNextInt()) {
            return scanner.nextInt();
        } else {
            System.out.println("Укажите повторяемость");
        }

        return -1;
    }

    private static void printTasksByDate(Scanner scanner) {
        System.out.println("Введите дату в формате DD.MM.YYYY");
        if (scanner.hasNext(DATE_PATTERN)) {
            String dateTime = scanner.next(DATE_PATTERN);
            LocalDate inputDate = LocalDate.parse(dateTime, DATE_FORMATTER);

            Collection<Task> taskByDay = TASK_SERVICE.getAllByDate(inputDate);
            for (Task task : taskByDay) {
                System.out.println(task);
            }
        } else {
            System.out.println("Введите дату и время задачи в формате DD.MM.YYYY HH:MM");
        }
    }

    private static void printMenu() {
        System.out.println("1. Добавить задачу\n2. Удалить задачу\n3. Получить задачу на указанный день\n4. Выход");
    }
}