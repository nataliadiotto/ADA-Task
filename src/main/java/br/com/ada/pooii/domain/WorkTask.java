package br.com.ada.pooii.domain;

import java.time.LocalDateTime;
import java.util.Random;

public class WorkTask extends BaseTask{

    private String project;

    public WorkTask(String title, String description, Priority priority, String project) {
        super(title, description, priority);
        this.project = project;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }
}
