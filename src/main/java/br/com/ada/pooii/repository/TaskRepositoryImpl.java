package br.com.ada.pooii.repository;

import br.com.ada.pooii.domain.BaseTask;

import java.util.ArrayList;
import java.util.List;

// TODO: 22/01/24 Implement update task
// TODO: 22/01/24 return a copy of the list to avoid external modifications

// TODO: 22/01/24 list tasks by ID - fix implementation, returning null at all times
// TODO: 22/01/24 list tasks by priority - return all tasks (it's returning only the 1st one)
// TODO: 22/01/24 list tasks by creation date


public class TaskRepositoryImpl<T extends BaseTask, U> implements Repository<T, U> {

    private List<T> tasks;

    public TaskRepositoryImpl() {
        this.tasks = new ArrayList<>();
    }

    @Override
    public void addTask(T task) {
        this.tasks.add(task);
    }

    @Override
    public void deleteTask(U id) {
        Integer index = findIndexById((Integer) id);
        this.tasks.remove(index);
    }

    @Override
    public void updateTask(T task) {
        Integer index = findIndexById(task.getId());
        tasks.set(index, task);
    }

    @Override
    public List<T> findAll() {
        return this.tasks;
    }

    @Override
    public T findById(U id) {
        for (T task: tasks) {
            if (task.getId().equals(id)) {
                return task;
            }
        } return null;
    }


    public T findByPriority(String priority) {
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

