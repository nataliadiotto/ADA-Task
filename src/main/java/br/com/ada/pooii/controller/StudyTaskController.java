package br.com.ada.pooii.controller;

import br.com.ada.pooii.domain.BaseTask;
import br.com.ada.pooii.domain.Priority;
import br.com.ada.pooii.domain.StudyTask;
import br.com.ada.pooii.service.TaskService;


import java.util.Scanner;

public class StudyTaskController <T extends BaseTask> implements TaskController{

    private final TaskService<T, Integer> taskService;

    private Scanner sc;

    public StudyTaskController(TaskService<T, Integer> taskService) {
        this.taskService = taskService;
        this.sc = new Scanner(System.in);
    }

    @Override
    public void createTask() {
        System.out.print("Insert task title: ");
        String title = sc.nextLine();
        System.out.println("Insert task description: ");
        String description = sc.nextLine();

        Priority priority = choosePriority();
        System.out.println("Insert study task subject: ");
        String studySubject = sc.nextLine();

        StudyTask studyTask = new StudyTask(title, description, priority, studySubject);
        taskService.saveTask((T) studyTask);// como fazer sem casting?
        System.out.println("Study Task saved successfully!");
    }

    @Override
    public void displayTasks() {
        var tasks = taskService.findAll();
    }

    @Override
    public void updateTask() {
        System.out.println("Choose a task to edit (id): ");
        Integer id = sc.nextInt();
        T selectedTask = taskService.findById(id);

        System.out.print("Insert new task title: ");
        String newTitle = sc.nextLine();
        selectedTask.setTitle(newTitle);

        System.out.println("Insert new task description: ");
        String newDescription = sc.nextLine();
        selectedTask.setDescription(newDescription);

        System.out.println("Choose a new task priority: ");
        Priority newPriority = choosePriority();
        selectedTask.setPriority(newPriority);

        //check if selectedTask has studySubject attribute
        if (selectedTask instanceof StudyTask) {
            System.out.println("Insert new study task subject: ");
            String studySubject = sc.nextLine();
            ((StudyTask) selectedTask).setStudySubject(studySubject);
        }

        taskService.updateTask(selectedTask);
        System.out.println("Study Task updated successfully!");

    }

    @Override
    public void deleteTask() {
        System.out.println("Choose a task to delete (id): ");
        Integer id = sc.nextInt();

        taskService.deleteTask(id);
        System.out.println("Study task deleted successfully!");
    }
}
