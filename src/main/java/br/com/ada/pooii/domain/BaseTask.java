package br.com.ada.pooii.domain;

import br.com.ada.pooii.domain.enums.CurrentStatus;
import br.com.ada.pooii.domain.enums.Priority;
import br.com.ada.pooii.domain.enums.TaskType;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// TODO: 22/01/24 add deadline
// TODO: 22/01/24 format id
// TODO: 22/01/24 format createdAt


public class BaseTask {

    private Integer id;
    private String title;
    private String description;
    private TaskType taskType;
    private LocalDateTime createdAt;
    private Priority priority;
    private CurrentStatus currentStatus;

    public BaseTask(String title, String description, TaskType taskType, Priority priority, CurrentStatus currentStatus) {
        this.id = generateId();
        this.title = title;
        this.description = description;
        this.taskType = taskType;
        this.createdAt = LocalDateTime.now();
        this.priority = priority;
        this.currentStatus = currentStatus;

    }

    private static int lastId = 0; // Static variable to keep track of the last generated ID

    private static synchronized int generateId() {
        return ++lastId; // Increment and return the last ID
    }

    public Integer getId() {
        return id;
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

    public CurrentStatus getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(CurrentStatus currentStatus) {
        this.currentStatus = currentStatus;
    }

    public String formatCreatedAt() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy - HH:mm:ss");

        // Format the createdAt timestamp using the defined formatter
        return createdAt.format(formatter);
    }
    public void printTasks()  {
        System.out.println("\n-------- TASK --------");
        System.out.println("Id: " + id);
        System.out.println("Title: " + title);
        System.out.println("Description: " + description);
        System.out.println( "Created at: " + formatCreatedAt());
        System.out.println("Priority: " + priority );
    }
}
