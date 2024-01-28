package br.com.ada.pooii.controller;

import br.com.ada.pooii.domain.enums.CurrentStatus;
import br.com.ada.pooii.domain.BaseTask;
import br.com.ada.pooii.domain.PersonalTask;
import br.com.ada.pooii.domain.StudyTask;
import br.com.ada.pooii.domain.WorkTask;
import br.com.ada.pooii.domain.enums.Priority;
import br.com.ada.pooii.repository.TaskRepositoryImpl;
import br.com.ada.pooii.service.TaskService;

import java.util.Scanner;

public interface TaskController <T extends BaseTask> {

    void createTask();

    void displayTasks();

   void updateTask(Integer taskId, T task);

    void deleteTask(Integer taskId);

    default Priority choosePriority() {
        Priority priority = null;
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.println("Choose task priority: ");
        System.out.println("1. High");
        System.out.println("2. Medium");
        System.out.println("3. Low");
        System.out.print("Insert option: ");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                return Priority.HIGH;
            case 2:
                return Priority.MEDIUM;
            case 3:
                return Priority.LOW;
            default:
                System.out.println("Choose a valid option.");
                return choosePriority();
        }
    }

    default CurrentStatus chooseStatus() {
        CurrentStatus currentStatus = null;
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.println("Choose task status: ");
        System.out.println("1. Pending");
        System.out.println("2. In progress");
        System.out.println("3. Completed");
        System.out.print("Insert option: ");
        int statusChoice = sc.nextInt();

        switch (statusChoice) {
            case 1:
                return CurrentStatus.PENDING;
            case 2:
                return CurrentStatus.IN_PROGRESS;
            case 3:
                return CurrentStatus.COMPLETED;
            default:
                System.out.println("Choose a valid option.");
                return chooseStatus();

        }

    }

    default void updateTaskByType(Integer taskId, T task) {
        if (task == null) {
            System.out.println("Task not found.");
            return;
        }

        if (task instanceof PersonalTask) {
            PersonalTaskController personalTaskController = new PersonalTaskController(new TaskService<>(TaskRepositoryImpl.getInstance()));
            personalTaskController.updateTask(taskId, task);
        return;
        }
        if (task instanceof StudyTask) {
            StudyTaskController studyTaskController = new StudyTaskController(new TaskService<>(TaskRepositoryImpl.getInstance()));
            studyTaskController.updateTask(taskId, task);
        return;
        }
        if (task instanceof WorkTask) {
            WorkTaskController workTaskController = new WorkTaskController(new TaskService<>(TaskRepositoryImpl.getInstance()));
            workTaskController.updateTask(taskId, task);
        return;
        }
        System.out.println("Invalid task type.");
    }

}
