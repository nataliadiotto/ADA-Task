package br.com.ada.pooii;

import br.com.ada.pooii.domain.BaseTask;
import br.com.ada.pooii.domain.PersonalTask;
import br.com.ada.pooii.domain.StudyTask;
import br.com.ada.pooii.domain.WorkTask;
import br.com.ada.pooii.repository.TaskRepositoryImpl;

import java.util.Locale;
import java.util.Scanner;

public class ConsoleInterface {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        TaskRepositoryImpl taskRepository = new TaskRepositoryImpl<>();
        BaseTask testTask = new BaseTask("Test", "Test Task", "urgent");
        taskRepository.addTask(testTask);

        PersonalTask personalTask = new PersonalTask("Personal Test",
                "Personal Test Task", "urgent");
        taskRepository.addTask(personalTask);

        WorkTask workTask = new WorkTask("Work Test", "Work Test Task", "low");
        taskRepository.addTask(workTask);

        StudyTask studyTask = new StudyTask("Study Task", "Study Test Task", "low", "English");
        taskRepository.addTask(studyTask);

        System.out.println(taskRepository.findAll());

        System.out.println("FILTER BY PRIORITY");
        System.out.println(taskRepository.findByPriority("urgent"));

        System.out.println("\nREMOVING TASK");
        //taskRepository.removeTask(workTask);
        System.out.println(taskRepository.findAll());

//
//
//        System.out.print("Option: ");
//        Integer option = sc.nextInt();
//        if (option == 5) return;
//
//        switch (option){
//            case 1:
//                System.out.println("CREATING NEW TASK");
//                break;
//            case 2:
//                System.out.println("EDITING TASK");
//                break;
//            case 3:
//                System.out.println("DELETING TASK");
//                break;
//            case 4:
//                System.out.println("LISTING ALL TASKS");
//                break;
//            default:
//                System.out.println("Choose a valid option.");
//        }

        //dar opcoes de tipos de tasks no menu




        sc.close();

    }
}