package br.com.ada.pooii.repository;


import br.com.ada.pooii.domain.BaseTask;

import java.util.List;

public interface TaskRepository <T extends BaseTask> {

    void addTask(T task);
    void removeTask(T task);
    void updateTask(T task);

    List<T> getTasks();


}
