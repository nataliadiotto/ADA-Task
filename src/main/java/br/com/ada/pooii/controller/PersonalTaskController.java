package br.com.ada.pooii.controller;

import br.com.ada.pooii.domain.enums.CurrentStatus;
import br.com.ada.pooii.domain.BaseTask;
import br.com.ada.pooii.domain.PersonalTask;
import br.com.ada.pooii.domain.enums.Priority;
import br.com.ada.pooii.domain.enums.TaskType;
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
    public void createTask(TaskType taskType) {
        System.out.print("Insert task title: ");
        String title = sc.nextLine();
        System.out.print("Insert task description: ");
        String description = sc.nextLine();

        Priority priority = choosePriority();
        CurrentStatus status = chooseStatus();
        System.out.println("Insert personal task category: ");
        String category = sc.nextLine();

        BaseTask personalTask = new PersonalTask(title, description, taskType, priority, status, category);
        taskService.saveTask((T) personalTask);// como fazer sem casting?
        System.out.println("Personal Task saved successfully!");
    }

    @Override
    public void displayTasks() {
        taskService.findAll();
    }

    @Override
    public void updateTask(Integer taskId, BaseTask task) {
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
            System.out.print("Insert new personal task category: ");
            String updatedCategory = sc.nextLine();
            ((PersonalTask) selectedTask).setLabel(updatedCategory);
        }

        taskService.updateTask(selectedTask);
        System.out.println("Personal Task updated successfully!");

    }

    @Override
    public void deleteTask(Integer id) {
        taskService.deleteTask(id);
        System.out.println("Task deleted successfully!");
    }
}

