package br.com.ada.pooii.controller;

import br.com.ada.pooii.domain.BaseTask;
import br.com.ada.pooii.domain.WorkTask;
import br.com.ada.pooii.domain.enums.CurrentStatus;
import br.com.ada.pooii.domain.enums.Priority;
import br.com.ada.pooii.service.TaskService;

import java.util.Scanner;

public class WorkTaskController <T extends BaseTask> implements TaskController {

    private final TaskService<T, Integer> taskService;

    private Scanner sc;

    public WorkTaskController(TaskService<T, Integer> taskService) {
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
        System.out.print("Insert work task project: ");
        String project = sc.nextLine();

        BaseTask workTask = new WorkTask(title, description, priority, status, project);
        taskService.saveTask((T) workTask);// como fazer sem casting?
        System.out.println("Work Task saved successfully!");
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

        System.out.print("Insert new work task title: ");
        String updatedTitle = sc.nextLine();
        selectedTask.setTitle(updatedTitle);

        System.out.print("Insert new work task description: ");
        String updatedDescription = sc.nextLine();
        selectedTask.setDescription(updatedDescription);

        Priority updatedPriority = choosePriority();
        selectedTask.setPriority(updatedPriority);

        CurrentStatus updatedStatus = chooseStatus();
        selectedTask.setCurrentStatus(updatedStatus);

        //check if selectedTask has project attribute
        if (selectedTask instanceof WorkTask) {
            System.out.println("Insert new work task project: ");
            String updatedProject = sc.nextLine();
            ((WorkTask) selectedTask).setProject(updatedProject);
        }

        taskService.updateTask(selectedTask);
        System.out.println("Work Task updated successfully!");

    }

    public void deleteTask(Integer id) {
        taskService.deleteTask(id);
        System.out.println("Task deleted successfully!");
    }
}


