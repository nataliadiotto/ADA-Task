package br.com.ada.pooii.repository;

import br.com.ada.pooii.domain.BaseTask;

import java.util.ArrayList;
import java.util.List;

// TODO: 22/01/24 Implement update task
// TODO: 22/01/24 return a copy of the list to avoid external modifications


public class TaskRepositoryImpl<T extends BaseTask> implements TaskRepository<T>{

    private List<T> tasks;

    public TaskRepositoryImpl() {
        this.tasks = new ArrayList<>();
    }

    @Override
    public void addTask(T task) {
        tasks.add(task);
    }

    @Override
    public void removeTask(T task) {
        tasks.remove(task);
    }

    @Override
    public void updateTask(T task) {
        //implementar
    }

    @Override
    public List<T> getTasks() {
        return tasks; // Retornar uma cópia da lista para evitar modificações externas
    }


}
