package br.com.ada.pooii.repository;


import br.com.ada.pooii.domain.BaseTask;

import java.util.List;

public interface Repository<T extends BaseTask, U> {

    void addTask(T task);
    T findById(U id);
    List<T> findAll();
    void updateTask(T task);
    void deleteTask(U id);
    T findByPriority(String priority);






}
