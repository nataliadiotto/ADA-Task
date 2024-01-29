package br.com.ada.pooii;

import br.com.ada.pooii.controller.*;
import br.com.ada.pooii.domain.BaseTask;
import br.com.ada.pooii.domain.PersonalTask;
import br.com.ada.pooii.domain.StudyTask;
import br.com.ada.pooii.domain.WorkTask;
import br.com.ada.pooii.domain.enums.CurrentStatus;
import br.com.ada.pooii.domain.enums.Priority;
import br.com.ada.pooii.domain.enums.TaskType;
import br.com.ada.pooii.repository.TaskRepositoryImpl;
import br.com.ada.pooii.service.TaskService;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        TaskRepositoryImpl<BaseTask, Integer> taskRepository = TaskRepositoryImpl.getInstance();
        TaskService<BaseTask, Integer> taskService = new TaskService(taskRepository);
        populateList(taskService); // Pass taskService to populateList

        // Create controllers for different task types
        TaskController<BaseTask> personalTaskController = new PersonalTaskController<>(taskService);
        TaskController<BaseTask> studyTaskController = new StudyTaskController<>(taskService);
        TaskController<BaseTask> workTaskController = new WorkTaskController<>(taskService);

        // Initialize TaskMenuController with one of the task controllers
        TaskMenuController<BaseTask> taskMenuController = new TaskMenuController<>(personalTaskController);
        taskMenuController.start();

        sc.close();
    }

    protected static void populateList(TaskService<BaseTask, Integer> taskService) {
        BaseTask personalTask = new PersonalTask("Clean bedroom",
                "I need to clean my bedroom",
                TaskType.PERSONAL,
                Priority.LOW,
                CurrentStatus.PENDING,
                "house chores");
        taskService.saveTask(personalTask);

        BaseTask workTask = new WorkTask("Confirm new hire",
                "Call Mr. Peabody from H.R. to confirm new accountant hire",
                TaskType.WORK,
                Priority.HIGH,
                CurrentStatus.PENDING,
                "Budget Review");
        taskService.saveTask(workTask);

        BaseTask studyTask = new StudyTask("Prepare presentation",
                "Prepare ppt presentation on Phonetics and Phonology",
                TaskType.STUDY,
                Priority.MEDIUM,
                CurrentStatus.IN_PROGRESS,
                "English");
        taskService.saveTask(studyTask);
    }
}
