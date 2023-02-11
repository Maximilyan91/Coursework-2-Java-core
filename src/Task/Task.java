package Task;

import Exception.IncorrectArgumentException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public abstract class Task implements Repeatable {
    private static final int idGenerator = 1;  // Также для более гибкого управления задачами рекомендуется завести поле id, которое нужно проставлять через генератор.
    private String title;   // Заголовок задачи.(Каждая задача обязательно имеет заголовок)
    private Type type;    // Также все задачи обязательно нужно делить по типу: личные или рабочие задачи
    private int id;
    private LocalDateTime dateTime;  // У каждой задачи есть дата и время, которые были присвоены при создании.
    private String description;  // Описание задачи(У каждой задачи может быть поле для описания)

    public Task(String title, Type type, String description, LocalDateTime taskTime) throws IncorrectArgumentException {
        setTitle(title);
        this.type = type;
        this.dateTime = taskTime;
        setDescription(description);
        id = idGenerator;
        id++;
    }

    public Type getType() {
        return type;
    }

    public String getTitle() {
        return title;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setTitle(String title) throws IncorrectArgumentException {
        if (title != null && !title.isEmpty() && !title.isBlank()) {
            this.title = title;
        } else {
            throw new IncorrectArgumentException("загололвок задачи");
        }
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) throws IncorrectArgumentException {
        if (description != null && !description.isEmpty() && !description.isBlank()) {
            this.description = description;
        } else {
            throw new IncorrectArgumentException("загололвок описания");
        }
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
        return "id = " + id +
                "idgen = " + idGenerator +
                ", Заголовок = " + title +
                ", Тип = " + type +
                ", Дата = " + dateTime +
                ", Описание = " + description;
    }
}

