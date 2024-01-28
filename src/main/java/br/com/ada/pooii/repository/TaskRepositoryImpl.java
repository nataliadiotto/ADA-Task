package br.com.ada.pooii.repository;

import br.com.ada.pooii.domain.BaseTask;
import br.com.ada.pooii.domain.enums.Priority;

import java.util.ArrayList;
import java.util.List;

// TODO: 22/01/24 return a copy of the list to avoid external modifications

// TODO: 22/01/24 list tasks by priority - return all tasks (it's returning only the 1st one)
// TODO: 22/01/24 list tasks by creation date


public class TaskRepositoryImpl<T extends BaseTask, U> implements Repository<T, U> {

    private static TaskRepositoryImpl instance;
    private List<T> tasks;
   // private Integer id = 1;

    private TaskRepositoryImpl(){
        this.tasks = new ArrayList<>();
    }

    //making it a singleton class, ensuring that only one instance exists at any given time
    public static TaskRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new TaskRepositoryImpl();
        }
        return instance;
    }

    @Override
    public void addTask(T task) {
       // task.setId(id);
       // id++;
        this.tasks.add(task);
    }

    @Override
    public void deleteTask(Integer id) {
        Integer taskIndex = findIndexById(id);
        this.tasks.remove(taskIndex);
    }

    @Override
    public void updateTask(T task) {
        Integer taskIndex = findIndexById(task.getId());
        tasks.set(taskIndex, task);
    }

    @Override
    public List<T> findAll() {
        return this.tasks;
    }

    @Override
    public T findById(Integer id) {
        Integer taskIndex = findIndexById(id);
        if (taskIndex != -1) {
            return this.tasks.get(taskIndex);
        }
        throw new IllegalArgumentException("No tasks were found with ID: " + id);
    }


    public T findByPriority(Priority priority) {
        for (T task : tasks) {
            if (task.getPriority().equals(priority)) {
                return task;
            }
        }
        return null;
    }

    public Integer findIndexById(Integer id) {
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getId().equals(id)){
                return i;
            }

        }
        return -1;
    }

}

