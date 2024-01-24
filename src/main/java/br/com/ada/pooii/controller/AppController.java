package br.com.ada.pooii.controller;

import java.util.Scanner;

public class AppController {

    private final TaskController taskController;

    private final Scanner sc;


    public AppController(TaskController taskController, Scanner sc) {
        this.taskController = taskController;
        this.sc = sc;
    }

    public void start(){
        System.out.println("----- ADA Task -----\n");

        mainMenu();
        Integer option = sc.nextInt();
        if (option == 5) return;

        while(true) {
            switch (option){
                case 1:
                    System.out.println("CREATE NEW TASK");
                    break;
                case 2:
                    System.out.println("EDIT TASK");
                    break;
                case 3:
                    System.out.println("DELETE TASK");
                    break;
                case 4:
                    System.out.println("LIST ALL TASKS");
                    break;
                default:
                    System.out.println("Choose a valid option.");
            }
        }


    }

    public void mainMenu() {
        System.out.println("----- MENU -----");
        System.out.println(
                    "Choose an option:\n" +
                    "1. Create new task\n" +
                    "2. Edit task\n" +
                    "3. Delete task\n" +
                    "4. List all tasks\n" +
                    "5. Exit\n");
        System.out.print("Choose an option: ");
    }
}
