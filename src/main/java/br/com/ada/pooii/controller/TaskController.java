package br.com.ada.pooii.controller;

import br.com.ada.pooii.domain.*;
import br.com.ada.pooii.domain.enums.CurrentStatus;
import br.com.ada.pooii.domain.enums.Priority;
import br.com.ada.pooii.repository.TaskRepositoryImpl;
import br.com.ada.pooii.service.TaskService;

import java.util.Scanner;

public interface TaskController <T extends BaseTask> {

    void createTask();

    void displayTasks();

   void updateTask(T task);

    void deleteTask();

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

    default void start(){
        TaskRepositoryImpl taskRepository = TaskRepositoryImpl.getInstance();
        Scanner sc = new Scanner(System.in);
        System.out.println("----- ADA Task -----\n");

        while(true) {
            mainMenu();
            int mainMenuOption = sc.nextInt();
            switch (mainMenuOption){
                case 1:
                    System.out.println("--- CREATE NEW TASK ---");
                    taskTypeMenu();
                    break;
                case 2:
                    System.out.println("--- EDIT TASK ---");
                    System.out.println("Insert the ID: ");
                    int taskToEditID  = sc.nextInt();
                    BaseTask task = taskRepository.findById(taskToEditID);
                    updateTaskByType((T) task);
                    break;
                case 3:
                    System.out.println("--- DELETE TASK ---");
                    deleteTask();
                    break;
                case 4:
                    System.out.println("--- LIST ALL TASKS ---");
                    displayTasks();
                    break;
                case 5:
                    System.out.println("Exiting application...");
                    return;
                default:
                    System.out.println("Choose a valid option.");
            }
        }

    }

    static void mainMenu() {
        System.out.println("----- MENU -----");
        System.out.println(
                "Choose an option:\n" +
                        "1. Create new task\n" +
                        "2. Edit task\n" +
                        "3. Delete task\n" +
                        "4. List all tasks\n" +
                        "5. Exit");
        System.out.print("Choose an option: ");
        System.out.println();
    }

    static void taskTypeMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Select task type:\n" +
                "1. Personal Task\n" +
                "2. Study Task\n" +
                "3. Work Task");
        System.out.print("Choose an option: ");
        int taskOption = sc.nextInt();
        System.out.println();
        String taskType;

        switch (taskOption){
            case 1:
                taskType = "Personal Task";
                TaskController<PersonalTask> personalTaskController = new PersonalTaskController(new TaskService<>(TaskRepositoryImpl.getInstance()));
                personalTaskController.createTask();
                break;
            case 2:
                taskType = "Study Task";
                TaskController<StudyTask> studyTaskTaskController = new StudyTaskController<>(new TaskService<>(TaskRepositoryImpl.getInstance()));
                studyTaskTaskController.createTask();
                break;
            case 3:
                taskType = "Work Task";
                TaskController<WorkTask> workTaskTaskController = new WorkTaskController<>(new TaskService<>(TaskRepositoryImpl.getInstance()));
                workTaskTaskController.createTask();
                break;
            default:
                System.out.println("Choose a valid option.");
        }
    }

    default void updateTaskByType(T task) {
        if (task instanceof PersonalTask) {
            PersonalTaskController personalTaskController = new PersonalTaskController(new TaskService<>(TaskRepositoryImpl.getInstance()));
            personalTaskController.updateTask(task);
        return;
        }
        if (task instanceof StudyTask) {
            StudyTaskController studyTaskController = new StudyTaskController(new TaskService<>(TaskRepositoryImpl.getInstance()));
            studyTaskController.updateTask(task);
        return;
        }
        if (task instanceof WorkTask) {
            WorkTaskController workTaskController = new WorkTaskController(new TaskService<>(TaskRepositoryImpl.getInstance()));
            workTaskController.updateTask(task);
        return;
        }
        System.out.println("Invalid task type.");
    }

//    static void newBaseTask() {
//        Scanner sc = new Scanner(System.in);
//        System.out.print("Insert task title: ");
//        String title = sc.nextLine();
//        System.out.println("Insert task description: ");
//        String description = sc.nextLine();
//
//    }

}
