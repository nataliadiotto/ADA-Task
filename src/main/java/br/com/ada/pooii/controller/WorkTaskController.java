package br.com.ada.pooii.controller;

import br.com.ada.pooii.domain.BaseTask;
import br.com.ada.pooii.domain.WorkTask;
import br.com.ada.pooii.domain.enums.CurrentStatus;
import br.com.ada.pooii.domain.enums.Priority;
import br.com.ada.pooii.domain.enums.TaskType;
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
    public void createTask(TaskType taskType) {
        System.out.print("Insert work task title: ");
        String title = sc.nextLine();
        System.out.print("Insert work task description: ");
        String description = sc.nextLine();

        Priority priority = choosePriority();

        System.out.print("Insert work task deadline (mm/dd/yyyy): ");
        String deadline = sc.nextLine();

        CurrentStatus status = chooseStatus();
        System.out.print("Insert work task project: ");
        String project = sc.nextLine();

        BaseTask workTask = new WorkTask(title, description, taskType, deadline, priority, status, project);
        taskService.saveTask((T) workTask);// como fazer sem casting?
        System.out.println("Work Task saved successfully!");
    }

    @Override
    public void displayTasks() {
        taskService.findAll();
    }

    @Override
    public void updateTask(Integer taskId, BaseTask task) {
        T selectedTask = taskService.findById(taskId);

        System.out.print("Insert new work task title: ");
        String updatedTitle = sc.nextLine();

        System.out.print("Insert new work task description: ");
        String updatedDescription = sc.nextLine();

        System.out.print("Insert new work deadline (mm/dd/yyyy): ");
        String updatedDeadline = sc.nextLine();

        Priority updatedPriority = choosePriority();

        CurrentStatus updatedStatus = chooseStatus();

        //check if selectedTask has project attribute
        if (selectedTask.getTaskType() == TaskType.WORK) {
            System.out.print("Insert new work task project: ");
            String updatedProject = sc.nextLine();
            ((WorkTask) selectedTask).setProject(updatedProject);
        }

        selectedTask.setTitle(updatedTitle);
        selectedTask.setDescription(updatedDescription);
        selectedTask.setDeadline(updatedDeadline);
        selectedTask.setPriority(updatedPriority);
        selectedTask.setCurrentStatus(updatedStatus);

        taskService.updateTask(selectedTask);
        System.out.println("Work Task updated successfully!");

    }

    public void deleteTask(Integer id) {
        taskService.deleteTask(id);
        System.out.println("Task deleted successfully!");
    }
}


