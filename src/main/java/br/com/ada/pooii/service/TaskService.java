package br.com.ada.pooii.service;

import br.com.ada.pooii.domain.BaseTask;
import br.com.ada.pooii.repository.TaskRepositoryImpl;

import java.util.List;

public class TaskService <T extends BaseTask>{

    private final TaskRepositoryImpl taskRepositoryImpl;

    public TaskService(TaskRepositoryImpl taskRepositoryImpl) {
        this.taskRepositoryImpl = taskRepositoryImpl;
    }

    public void saveTask(T task) {
        System.out.println("Saving task");
        taskRepositoryImpl.addTask(task);
    }

    public void deleteTask(T task) {
        System.out.println("Deleting task");
        taskRepositoryImpl.removeTask(task);
    }

    //update task nao é a mesma coisa que get + save?
    public void updateTask(T task) {
        System.out.println("Updating task!");
        taskRepositoryImpl.updateTask(task);
    }

    public List<T> listTasks(List<T> tasks) {
        System.out.println("Task saved!");
        return taskRepositoryImpl.getTasks();
    }



}
