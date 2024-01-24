package br.com.ada.pooii.controller;

import br.com.ada.pooii.domain.BaseTask;
import br.com.ada.pooii.service.TaskService;

import java.util.Scanner;

// TODO: 22/01/24 descobrir a diferenca entre controller e repository

public class TaskController <T extends BaseTask> {

    private final TaskService<T, Integer> taskService;
    private Scanner sc;

    public TaskController(TaskService<T, Integer> taskService) {
        this.taskService = taskService;
        this.sc = new Scanner(System.in);
    }

    public void createTask(){
        System.out.print("Enter your task description: ");
        String description = sc.nextLine();
        System.out.print("Enter your task priority (1. High, 2. Medium, 3. Low): ");
        String priority = sc.nextLine();

        };

    void deleteTask();
    void editTask();
    void displayTasks();

}
