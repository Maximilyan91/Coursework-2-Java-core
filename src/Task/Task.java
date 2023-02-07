package Task;

import java.time.LocalDate;
import java.util.Objects;

public class Task {
    private int idGenerator;  // Также для более гибкого управления задачами рекомендуется завести поле id, которое нужно проставлять через генератор.
    private String title;   // Заголовок задачи.(Каждая задача обязательно имеет заголовок)
    private Type type;    // Также все задачи обязательно нужно делить по типу: личные или рабочие задачи
    private int id;
    //    private LocalDate dateTime;  // У каждой задачи есть дата и время, которые были присвоены при создании.
    private String description;  // Описание задачи(У каждой задачи может быть поле для описания)

    public Task(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id && title.equals(task.title) && description.equals(task.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, id, description);
    }
}
