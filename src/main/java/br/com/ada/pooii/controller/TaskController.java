package br.com.ada.pooii.controller;

import br.com.ada.pooii.domain.BaseTask;

import java.util.ArrayList;
import java.util.List;

// TODO: 22/01/24 descobrir a diferenca entre controller e repository

public class TaskController <T extends BaseTask> {

    private List<T> tasksList;

    public TaskController() {
        this.tasksList = new ArrayList<T>();
    }

    public void save(T task) {
        tasksList.add(task);
    }

    public void delete(Integer id) {
        for (T task: tasksList) {
            if (id.equals(task.getId())) {
                tasksList.remove(task);
            }
        }
    }

    public void edit(Integer id) {

    }





}
