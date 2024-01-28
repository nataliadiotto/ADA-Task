package br.com.ada.pooii.domain;

import br.com.ada.pooii.domain.enums.CurrentStatus;
import br.com.ada.pooii.domain.enums.Priority;

public class WorkTask extends BaseTask{

    private String project;

    public WorkTask(String title, String description, Priority priority, CurrentStatus currentStatus, String project) {
        super(title, description, priority, currentStatus);
        this.project = project;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    @Override
    public void printTasks() {
        super.printTasks();
        System.out.println("Project: " + project);
    }
}
