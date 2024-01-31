package br.com.ada.pooii.domain;

import br.com.ada.pooii.domain.enums.CurrentStatus;
import br.com.ada.pooii.domain.enums.Priority;
import br.com.ada.pooii.domain.enums.TaskType;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class BaseTask {

    private Integer id;
    private String title;
    private String description;
    private TaskType taskType;
    private String deadline;
    private LocalDateTime createdAt;
    private Priority priority;
    private CurrentStatus currentStatus;

    private static DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
    private static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy - HH:mm:ss");

    public BaseTask(String title, String description, TaskType taskType, String deadline, Priority priority, CurrentStatus currentStatus) {
        this.id = generateId();
        this.title = title;
        this.description = description;
        this.taskType = taskType;
        LocalDate parsedDeadline = parseDeadline(deadline.trim());
        this.deadline = dateFormatter.format(parsedDeadline);
        this.createdAt = LocalDateTime.now();
        this.priority = priority;
        this.currentStatus = currentStatus;

    }

    private LocalDate parseDeadline(String deadlineString) {
        try {
            return LocalDate.parse(deadlineString, dateFormatter);
        } catch (DateTimeParseException e) {
            System.out.println("Error parsing deadline: " + e.getMessage());
            throw e;
        }
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

    public TaskType getTaskType() {
        return taskType;
    }

    public void setTaskType(TaskType taskType) {
        this.taskType = taskType;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public void printTasks()  {
        System.out.println("\n-------- " + taskType + " TASK --------");
        System.out.println("Id: " + id);
        System.out.println("Title: " + title);
        System.out.println("Description: " + description);
        System.out.println("Deadline: " + deadline);
        System.out.println("Priority: " + priority );
        System.out.println("Created at: " + createdAt.format(dateTimeFormatter));
    }
}
