package br.com.ada.pooii.controller;

import br.com.ada.pooii.domain.*;
import br.com.ada.pooii.domain.enums.CurrentStatus;
import br.com.ada.pooii.domain.enums.Priority;
import br.com.ada.pooii.service.TaskService;

import java.util.Scanner;

public class PersonalTaskController <T extends BaseTask> implements TaskController {

    private final TaskService<T, Integer> taskService;

    private Scanner sc;

    public PersonalTaskController(TaskService taskService) {
        this.taskService = taskService;
        this.sc = new Scanner(System.in);
    }

    @Override
    public void createTask() {
        System.out.print("Insert task title: ");
        String title = sc.nextLine();
        System.out.print("Insert task description: ");
        String description = sc.nextLine();

        Priority priority = choosePriority();
        CurrentStatus status = chooseStatus();
        System.out.println("Insert personal task category: ");
        String category = sc.nextLine();

        BaseTask personalTask = new PersonalTask(title, description, priority, status, category);
        taskService.saveTask((T) personalTask);// como fazer sem casting?
        System.out.println("Personal Task saved successfully!");
    }

    @Override
    public void displayTasks() {
        taskService.findAll();
    }

    @Override
    public void updateTask(Integer taskId, BaseTask task) {
//        System.out.println("Choose a task to edit (id): ");
//        Integer id = sc.nextInt();
        T selectedTask = taskService.findById(taskId);

        System.out.print("Insert new personal task title: ");
        String updatedTitle = sc.nextLine();
        selectedTask.setTitle(updatedTitle);

        System.out.print("Insert new personal task description: ");
        String updatedDescription = sc.nextLine();
        selectedTask.setDescription(updatedDescription);

        Priority updatedPriority = choosePriority();
        selectedTask.setPriority(updatedPriority);

        CurrentStatus updatedStatus = chooseStatus();
        selectedTask.setCurrentStatus(updatedStatus);

        //check if selectedTask has category attribute
        if (selectedTask instanceof PersonalTask) {
            System.out.println("Insert new personal task category: ");
            String updatedCategory = sc.nextLine();
            ((PersonalTask) selectedTask).setCategory(updatedCategory);
        }

        taskService.updateTask(selectedTask);
        System.out.println("Personal Task updated successfully!");

    }

    @Override
    public void deleteTask() {
        System.out.println("Choose a task to delete (id): ");
        Integer id = sc.nextInt();

        taskService.deleteTask(id);
        System.out.println("Personal task deleted successfully!");
    }
}

