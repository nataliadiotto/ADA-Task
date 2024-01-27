package br.com.ada.pooii;

import br.com.ada.pooii.controller.*;
import br.com.ada.pooii.domain.*;
import br.com.ada.pooii.repository.TaskRepositoryImpl;
import br.com.ada.pooii.service.TaskService;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        TaskRepositoryImpl<BaseTask, Integer> taskRepository = new TaskRepositoryImpl(); //basetask ou outro?
        TaskService<BaseTask, Integer> taskService = new TaskService(taskRepository);
        TaskController personalTaskController = new PersonalTaskController(taskService);
        TaskController studyTaskController = new StudyTaskController(taskService);
        TaskController workTaskController = new WorkTaskController(taskService);
//        AppController appController = new AppController(personalTaskController,
//                studyTaskController, workTaskController);
//
        BaseTask personalTask = new PersonalTask("Clean bedroom",
                "I need to clean my bedroom",
                Priority.LOW,
                CurrentStatus.PENDING,
                "house chores");
        taskService.saveTask(personalTask);

        BaseTask workTask = new WorkTask("Confirm new hire",
                "Call Mr. Peabody from H.R. to confirm new accountant hire",
                Priority.HIGH,
                CurrentStatus.PENDING,
                "Budget Review");
        taskService.saveTask(workTask);

        BaseTask studyTask = new StudyTask("Prepare presentation",
                "Prepare ppt presentation on Phonetics and Phonology",
                Priority.MEDIUM,
                CurrentStatus.IN_PROGRESS,
                "English");
        taskService.saveTask(studyTask);

        TaskController taskController = personalTaskController;
        taskController.start();


        sc.close();

    }
}