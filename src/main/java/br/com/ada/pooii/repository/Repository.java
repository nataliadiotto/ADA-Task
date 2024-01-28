package br.com.ada.pooii.repository;


import br.com.ada.pooii.domain.BaseTask;
import br.com.ada.pooii.domain.enums.Priority;

import java.util.List;

public interface Repository<T extends BaseTask, U> {

    void addTask(T task);
    T findById(Integer id);
    List<T> findAll();
    void updateTask(T task);
    void deleteTask(Integer id);
    T findByPriority(Priority priority);






}
