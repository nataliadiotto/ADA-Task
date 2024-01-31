package br.com.ada.pooii.service;

import br.com.ada.pooii.domain.BaseTask;
import br.com.ada.pooii.repository.TaskRepositoryImpl;

import java.util.List;

public class TaskService <T extends BaseTask, ID>{

    private final TaskRepositoryImpl<T, ID> taskRepositoryImpl;

    public TaskService(TaskRepositoryImpl<T, ID> taskRepositoryImpl) {
        this.taskRepositoryImpl = taskRepositoryImpl;
    }

    public void saveTask(T task) {
        System.out.println("Saving task " + task.getId() + " - " + task.getTitle() + "...");
        //Check if task title is unique
        if (isTitleUnique(task.getTitle())) {
                taskRepositoryImpl.addTask(task);
                System.out.println("Task saved successfully!");
        } else {
            System.out.println("A task with the same title already exists. Please use a unique title.");
        }
    }


    public void deleteTask(Integer id) {
        System.out.println("Deleting task " + id + "...");
        taskRepositoryImpl.deleteTask(id);
    }

    public void updateTask(T task) {
        System.out.println("Updating task " + task.getId() + "...");
        taskRepositoryImpl.updateTask(task);
    }

    public List<T> findAll() {
        System.out.println("Retrieving all tasks...");
        List<T> tasks = taskRepositoryImpl.findAll();
        for (T task : tasks) {
            task.printTasks();
        }
        return tasks;
    }

    public T findById(Integer id) {
        System.out.println("Retrieving task " + id + "...");
        return taskRepositoryImpl.findById(id);
    }

    //Check if task title is unique
    private boolean isTitleUnique(String title) {
        List<T> tasks = taskRepositoryImpl.findAll();
        for (T task : tasks) {
            if (task.getTitle().equals(title)) {
                return false; // Title already exists
            }
        }
        return true; // Title is unique
    }

}

