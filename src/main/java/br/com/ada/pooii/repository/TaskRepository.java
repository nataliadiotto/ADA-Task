package br.com.ada.pooii.repository;


import br.com.ada.pooii.domain.BaseTask;

import java.util.List;

// TODO: 22/01/24 list tasks by ID
// TODO: 22/01/24 list tasks by priority
// TODO: 22/01/24 list tasks by creation date

public interface TaskRepository <T extends BaseTask> {

    void addTask(T task);
    void removeTask(T task);
    void updateTask(T task);

    List<T> getTasks();


}
