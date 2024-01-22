package br.com.ada.pooii.repository;

import br.com.ada.pooii.domain.BaseTask;

import java.util.ArrayList;
import java.util.List;

// TODO: 21/01/24 fix type error (should be overriding T type, not BaseTask) 

public class InMemoryTaskRepository <T extends BaseTask> implements TaskRepository{

    private List<T> tasks;

    public InMemoryTaskRepository() {
        this.tasks = new ArrayList<>();
    }

    @Override
    public void addTask(BaseTask task) {

    }

    @Override
    public void removeTask(BaseTask task) {

    }

    @Override
    public void updateTask(BaseTask task) {

    }

    @Override
    public List getTasks() {
        return null;
    }

//    @Override
//    public void addTask(T task){
//        tasks.add(task);
//    }
//
//    @Override
//    public void removeTask(T task){
//        tasks.remove(task);
//    }
//
//    @Override
//    public void updateTask(T task) {
//        //implementar
//    }


    //// Retornar uma cópia da lista para evitar modificações externas


}
