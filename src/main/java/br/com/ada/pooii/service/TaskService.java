package br.com.ada.pooii.service;

import br.com.ada.pooii.domain.BaseTask;
import br.com.ada.pooii.repository.TaskRepositoryImpl;

import java.util.List;

public class TaskService <T extends BaseTask, Integer>{

    private final TaskRepositoryImpl<T, Integer> taskRepositoryImpl;

    public TaskService(TaskRepositoryImpl taskRepositoryImpl) {
        this.taskRepositoryImpl = taskRepositoryImpl;
    }

    public void saveTask(T task) {
        System.out.println("Saving task " + task.getId());
        taskRepositoryImpl.addTask(task);
    }

    public void deleteTask(Integer id) {
        System.out.println("Deleting task...");
        taskRepositoryImpl.deleteTask((java.lang.Integer) id);
    }

    //update task nao é a mesma coisa que get + save?
    public void updateTask(T task) {
        System.out.println("Updating task...");
        taskRepositoryImpl.updateTask(task);
    }

    public List<T> findAll(List<T> tasks) {
        System.out.println("Retrieving all tasks...");
        for (T task : tasks) {
            System.out.println(task);
        }
        return tasks;
    }

    public T findById(Integer id) {
        System.out.println("Retrieving task by id...");
        return taskRepositoryImpl.findById((java.lang.Integer) id);
    }



}
