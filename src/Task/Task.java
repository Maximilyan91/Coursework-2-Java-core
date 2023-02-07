package Task;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Random;

public abstract class Task {
    private static int idGenerator = 1;  // Также для более гибкого управления задачами рекомендуется завести поле id, которое нужно проставлять через генератор.
    private String title;   // Заголовок задачи.(Каждая задача обязательно имеет заголовок)
    private Type type;    // Также все задачи обязательно нужно делить по типу: личные или рабочие задачи
    private static int id;
    private LocalDate dateTime;  // У каждой задачи есть дата и время, которые были присвоены при создании.
    private String description;  // Описание задачи(У каждой задачи может быть поле для описания)

    public Task(String title, Type type, String description) {
        this.title = title;
        this.type = type;
        this.dateTime = LocalDate.now();
        this.description = description;
        this.id = idGenerator++;
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

    @Override
    public String toString() {
        return "Task{" +
                "idGenerator=" + idGenerator +
                ", title='" + title + '\'' +
                ", type=" + type +
                ", id=" + id +
                ", dateTime=" + dateTime +
                ", description='" + description + '\'' +
                '}';
    }

}
