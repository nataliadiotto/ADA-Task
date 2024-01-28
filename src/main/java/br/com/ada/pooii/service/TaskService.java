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
        taskRepositoryImpl.addTask(task);
    }

    public void deleteTask(Integer id) {
        System.out.println("Deleting task " + id + "...");
        taskRepositoryImpl.deleteTask(id);
    }

    //update task nao é a mesma coisa que get + save?
    public void updateTask(T task) {
        System.out.println("Updating task " + task.getId() + "...");
        taskRepositoryImpl.updateTask(task);
    }

    public List<T> findAll() {
        System.out.println("Retrieving all tasks...");
        List<T> tasks = taskRepositoryImpl.findAll();
        for (T task : tasks) {
            System.out.println(task);
        }
        return tasks;
    }

    public T findById(Integer id) {
        System.out.println("Retrieving task " + id + "...");
        return taskRepositoryImpl.findById(id);
    }



}
