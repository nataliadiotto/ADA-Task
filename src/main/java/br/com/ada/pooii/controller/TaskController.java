package br.com.ada.pooii.controller;

import br.com.ada.pooii.domain.BaseTask;
import br.com.ada.pooii.domain.Priority;
import br.com.ada.pooii.service.TaskService;

import java.util.Scanner;

public interface TaskController <T extends BaseTask> {

    void createTask();

    void displayTasks();

   void updateTask();

    void deleteTask();

    default Priority choosePriority() {
        Priority priority = null;
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose task priority: ");
        System.out.println("1. High");
        System.out.println("2. Medium");
        System.out.println("3. Low");
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
                return choosePriority(); //
        }

    }
}
