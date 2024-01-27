package br.com.ada.pooii.controller;

import java.util.Scanner;

public class AppController {

    private final TaskController taskController;

    private final Scanner sc;


    public AppController(TaskController personalTaskController, TaskController studyTaskController, TaskController workTaskController) {
        this.taskController = personalTaskController;
        this.sc = new Scanner(System.in);
    }

//    public static void start(){
//        Scanner sc = new Scanner(System.in);
//        System.out.println("----- ADA Task -----\n");
//
//        mainMenu();
//        int mainMenuOption = sc.nextInt();
//        if (mainMenuOption == 5) return;
//
//        while(true) {
//            switch (mainMenuOption){
//                case 1:
//                    System.out.println("CREATE NEW TASK");
//                    taskTypeMenu();
//
//                    break;
//                case 2:
//                    System.out.println("EDIT TASK");
//                    break;
//                case 3:
//                    System.out.println("DELETE TASK");
//                    break;
//                case 4:
//                    System.out.println("LIST ALL TASKS");
//                    break;
//                case 5:
//                    System.out.println("Exiting application...");
//                default:
//                    System.out.println("Choose a valid option.");
//            }
//        }
//
//    }
//
//    public static void mainMenu() {
//        System.out.println("----- MENU -----");
//        System.out.println(
//                "Choose an option:\n" +
//                        "1. Create new task\n" +
//                        "2. Edit task\n" +
//                        "3. Delete task\n" +
//                        "4. List all tasks\n" +
//                        "5. Exit");
//        System.out.print("Choose an option: ");
//    }
//
//    public static void taskTypeMenu() {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Select task type:" +
//                "1. Personal Task\n" +
//                "2. Study Task\n" +
//                "3. Work Task");
//        System.out.println("Choose an option: ");
//        int taskOption = sc.nextInt();
//        String taskType;
//        switch (taskOption){
//            case 1:
//                taskType = "Personal Task";
//                break;
//            case 2:
//                taskType = "Study Task";
//                break;
//            case 3:
//                taskType = "Work Task";
//                break;
//            default:
//                System.out.println("Choose a valid option.");
//        }
//    }
//
//    public static void newBaseTask() {
//        Scanner sc = new Scanner(System.in);
//        System.out.print("Insert task title: ");
//        String title = sc.nextLine();
//        System.out.println("Insert task description: ");
//        String description = sc.nextLine();
//
//    }

}
