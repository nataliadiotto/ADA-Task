package br.com.ada.pooii.domain;

import java.time.LocalDateTime;
import java.util.UUID;

// TODO: 22/01/24 add deadline
// TODO: 22/01/24 format id
// TODO: 22/01/24 format createdAt


public class BaseTask {

    private Integer id;
    private String title;
    private String description;
    private LocalDateTime createdAt;
    private Priority priority;

    public BaseTask(String title, String description, Priority priority) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.createdAt = LocalDateTime.now();
        this.priority = priority;
    }

    public Integer getId() {
        return id;
    }

    public void setId(){
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "\n-------- TASK --------" + "\n" +
                "Id: " + id + "\n" +
                "Title: " + title + "\n" +
                "Description: " + description + "\n" +
                "Created at: " + createdAt + "\n" +
                "Priority: " + priority +
                "\n";
    }
}
