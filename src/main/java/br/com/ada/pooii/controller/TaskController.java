package br.com.ada.pooii.controller;

import br.com.ada.pooii.domain.BaseTask;
import br.com.ada.pooii.service.TaskService;

import java.util.Scanner;

public interface TaskController <T extends BaseTask> {

    void start();
    void createTask();
    void displayTasks();
    void updateTask();
    void deleteTask();

}
