package br.com.ada.pooii.controller;

import br.com.ada.pooii.domain.BaseTask;
import br.com.ada.pooii.domain.StudyTask;
import br.com.ada.pooii.domain.enums.CurrentStatus;
import br.com.ada.pooii.domain.enums.Priority;
import br.com.ada.pooii.domain.enums.TaskType;
import br.com.ada.pooii.service.TaskService;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class StudyTaskController <T extends BaseTask> implements TaskController{

    private final TaskService<T, Integer> taskService;

    private Scanner sc;

    public StudyTaskController(TaskService<T, Integer> taskService) {
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

        System.out.print("Insert personal task deadline (mm/dd/yyyy): ");
        String deadline = sc.nextLine();

        CurrentStatus status = chooseStatus();
        System.out.print("Insert study task subject: ");
        String studySubject = sc.nextLine();

        BaseTask studyTask = new StudyTask(title, description, taskType, deadline, priority, status, studySubject);
        taskService.saveTask((T) studyTask);// como fazer sem casting?
        System.out.println("Study Task saved successfully!");
    }

    @Override
    public void displayTasks() {
        taskService.findAll();
    }

    @Override
    public void updateTask(Integer taskId, BaseTask task) {
        T selectedTask = taskService.findById(taskId);

        System.out.print("Insert new study task title: ");
        String updatedTitle = sc.nextLine();
        selectedTask.setTitle(updatedTitle);

        System.out.print("Insert new study task description: ");
        String updatedDescription = sc.nextLine();
        selectedTask.setDescription(updatedDescription);

        Priority updatedPriority = choosePriority();
        selectedTask.setPriority(updatedPriority);


        CurrentStatus updatedStatus = chooseStatus();
        selectedTask.setCurrentStatus(updatedStatus);

        //check if selectedTask has studySubject attribute
        if (selectedTask.getTaskType() == TaskType.STUDY) {
            System.out.println("Insert new study task subject: ");
            String updatedSubject = sc.nextLine();
            ((StudyTask) selectedTask).setStudySubject(updatedSubject);
        }

        taskService.updateTask(selectedTask);
        System.out.println("Study Task updated successfully!");

    }

    @Override
    public void deleteTask(Integer id) {
       taskService.deleteTask(id);
       System.out.println("Task deleted successfully!");
    }
}
