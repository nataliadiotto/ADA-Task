package br.com.ada.pooii.controller;

import br.com.ada.pooii.domain.BaseTask;
import br.com.ada.pooii.domain.Priority;
import br.com.ada.pooii.domain.StudyTask;
import br.com.ada.pooii.service.TaskService;


import java.util.Scanner;

public class StudyTaskController implements TaskController {

    private final TaskService<BaseTask, Integer> personalTaskService;

    private Scanner sc;

    public StudyTaskController(TaskService<BaseTask, Integer> personalTaskService) {
        this.personalTaskService = personalTaskService;
        this.sc = new Scanner(System.in);
    }

    @Override
    public void start() {

    }


    @Override
    public void createTask() {
        System.out.print("Insert task title: ");
        String title = sc.nextLine();
        System.out.println("Insert task description: ");
        String description = sc.nextLine();
        Priority priority = choosePriority();
        System.out.println("Insert study task subject: ");
        String studySubject = sc.nextLine();

        StudyTask studyTask = new StudyTask(title, description, priority, studySubject);
        personalTaskService.saveTask(studyTask);
        System.out.println("Study Task saved successfully!");
    }

    @Override
    public void displayTasks() {
        var tasks = personalTaskService.findAll();
    }

    @Override
    public void updateTask() {
        System.out.println("Insert task id: ");
        int id = sc.nextInt();
        StudyTask selectedTask = personalTaskService
    }

    @Override
    public void deleteTask() {

    }
}
