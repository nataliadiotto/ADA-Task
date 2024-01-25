package br.com.ada.pooii;

import br.com.ada.pooii.repository.TaskRepositoryImpl;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        TaskRepositoryImpl taskRepository = new TaskRepositoryImpl<>();
        //TaskService taskService = new TaskService<>(TaskRepositoryImpl);
       // TaskController taskController = new TaskController<>(taskService);
       // AppController controller = new AppController(TaskController, TaskService);


//        TaskRepositoryImpl taskRepository = new TaskRepositoryImpl<>();
//        BaseTask testTask = new BaseTask("Test", "Test Task", "urgent");
//        taskRepository.addTask(testTask);
//
//        PersonalTask personalTask = new PersonalTask("Personal Test",
//                "Personal Test Task", "urgent");
//        taskRepository.addTask(personalTask);
//
//        WorkTask workTask = new WorkTask("Work Test", "Work Test Task", "low");
//        taskRepository.addTask(workTask);
//
//        StudyTask studyTask = new StudyTask("Study Task", "Study Test Task", "low");
//        taskRepository.addTask(studyTask);
//
//        System.out.println(taskRepository.findAll());
//
//        System.out.println("FILTER BY PRIORITY");
//        System.out.println(taskRepository.findByPriority("urgent"));
//
//        System.out.println("\nREMOVING TASK");
//        //taskRepository.removeTask(workTask);
//        System.out.println(taskRepository.findAll());


        sc.close();

    }
}