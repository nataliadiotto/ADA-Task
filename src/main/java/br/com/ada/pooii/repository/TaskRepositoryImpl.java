package br.com.ada.pooii.repository;

import br.com.ada.pooii.domain.BaseTask;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

// TODO: 22/01/24 Implement update task
// TODO: 22/01/24 return a copy of the list to avoid external modifications

// TODO: 22/01/24 list tasks by ID - fix implementation, returning null at all times
// TODO: 22/01/24 list tasks by priority - return all tasks (it's returning only the 1st one)
// TODO: 22/01/24 list tasks by creation date


public class TaskRepositoryImpl<T extends BaseTask> implements Repository<T> {

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

    public List<T> getTasksByPriority(String priority){
        for (T task : tasks) {
            if (task.getPriority().equals(priority)) {
                List<T> tasksByPriority = new ArrayList<>();
                tasksByPriority.add(task);
                return tasksByPriority;
            }
        }
        return null;
    }

    public T getTaskByID(UUID id) {
        for (T task : tasks) {
            if (task.getId().equals(UUID.fromString(String.valueOf(id)))) {
                return task;
            }
        }
        return null;
    }

}
