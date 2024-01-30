package br.com.ada.pooii.controller;

import br.com.ada.pooii.domain.BaseTask;
import br.com.ada.pooii.domain.enums.TaskType;
import br.com.ada.pooii.repository.TaskRepositoryImpl;

import java.util.Scanner;

public class TaskMenuController<T extends BaseTask>{

    private final TaskController<T> taskController;

    public TaskMenuController(TaskController<T> taskController) {
        this.taskController = taskController;
    }
    public void start() {
        TaskRepositoryImpl taskRepository = TaskRepositoryImpl.getInstance();
        Scanner sc = new Scanner(System.in);
        System.out.println("----- ADA Task -----\n");

        while(true) {
            mainMenu();
            int mainMenuOption = sc.nextInt();
            switch (mainMenuOption){
                case 1:
                    System.out.println("--- CREATE NEW TASK ---");
                    System.out.println("Select task type:\n" +
                            "1. Personal Task\n" +
                            "2. Study Task\n" +
                            "3. Work Task");
                    System.out.print("Choose an option: ");
                    int taskOption = sc.nextInt();
                    TaskType taskType = taskController.chooseTaskType(taskOption);
                    break;
                case 2:
                    System.out.println("--- EDIT TASK ---");
                    System.out.print("Insert the task ID to edit: ");
                    int taskToEditID = sc.nextInt();
                    BaseTask task = taskRepository.findById(taskToEditID);
                    taskController.updateTask(taskToEditID, (T) task);
                    break;
                case 3:
                    System.out.println("--- DELETE TASK ---");
                    System.out.print("Insert the task ID to delete: ");
                    int taskToDeleteId  = sc.nextInt();
                    taskController.deleteTask(taskToDeleteId);
                    break;
                case 4:
                    System.out.println("--- LIST ALL TASKS ---");
                    taskController.displayTasks();
                    break;
                case 5:
                    System.out.println("Exiting application...");
                    return;
                default:
                    System.out.println("Choose a valid option.");
            }
        }

    }

    private static void mainMenu() {
        System.out.println("\n----- MENU -----");
        System.out.println(
                "Choose an option:\n" +
                        "1. Create new task\n" +
                        "2. Edit task\n" +
                        "3. Delete task\n" +
                        "4. List all tasks\n" +
                        "5. Exit");
        System.out.print("Choose an option: ");

    }

}
