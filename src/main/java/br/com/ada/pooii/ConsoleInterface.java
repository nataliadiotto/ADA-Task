package br.com.ada.pooii;

import java.util.Locale;
import java.util.Scanner;

public class ConsoleInterface {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);


        System.out.println("----- ADA Task -----\n" +
                    "Choose an option:\n" +
                    "1 - Create new task\n" +
                    "2 - Edit task\n" +
                    "3 - Delete task\n" +
                    "4 - List all tasks\n" +
                    "5 - Exit\n");

        System.out.print("Option: ");
        Integer option = sc.nextInt();
        if (option == 5) return;

        switch (option){
            case 1:
                System.out.println("CREATING NEW TASK");
                break;
            case 2:
                System.out.println("EDITING TASK");
                break;
            case 3:
                System.out.println("DELETING TASK");
                break;
            case 4:
                System.out.println("LISTING ALL TASKS");
                break;
            default:
                System.out.println("Choose a valid option.");
        }




        sc.close();

    }
}