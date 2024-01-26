package br.com.ada.pooii.controller;

import br.com.ada.pooii.domain.BaseTask;
import br.com.ada.pooii.service.TaskService;

import java.util.Scanner;

public class StudyTaskController implements TaskController {

    private final TaskService<BaseTask, Integer> personalTaskService;

    private Scanner sc;

    public StudyTaskController(TaskService<BaseTask, Integer> personalTaskService, Scanner sc) {
        this.personalTaskService = personalTaskService;
        this.sc = new Scanner(System.in);
    }

    @Override
    public void start() {
        System.out.println("Task description: ");
        String description = sc.nextLine();
        System.out.println("Task priority: ");
        Str
    }

    @Override
    public void createTask() {

    }

    @Override
    public void displayTasks() {

    }

    @Override
    public void updateTask() {

    }

    @Override
    public void deleteTask() {

    }
}
