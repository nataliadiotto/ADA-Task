package br.com.ada.pooii.domain;

import br.com.ada.pooii.domain.enums.CurrentStatus;
import br.com.ada.pooii.domain.enums.Priority;
import br.com.ada.pooii.domain.enums.TaskType;

public class PersonalTask extends BaseTask{

    private String label;

    public PersonalTask(String title, String description, TaskType taskType, String deadline, Priority priority, CurrentStatus currentStatus, String label) {
        super(title, description, taskType, deadline, priority, currentStatus);
        this.label = label;

    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public void printTasks() {
        super.printTasks();
        System.out.println("Label: " + label);
    }
}
