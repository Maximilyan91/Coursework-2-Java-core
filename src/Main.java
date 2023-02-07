import Task.DailyTask;
import Task.Type;

import java.time.LocalDate;

;

public class Main {
    public static void main(String[] args) {

        Task.DailyTask q = new DailyTask("Название", Type.WORK,"ваыв");
        System.out.println(q);
    }
}