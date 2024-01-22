package br.com.ada.pooii.domain;

import java.time.LocalDateTime;

public class BaseTask {

    private String id;
    private String title;
    private String description;
    private LocalDateTime createdAt;
    private String priority;

    public BaseTask(String id, String title, String description, LocalDateTime createdAt, String priority) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.createdAt = createdAt;
        this.priority = priority;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }
}
