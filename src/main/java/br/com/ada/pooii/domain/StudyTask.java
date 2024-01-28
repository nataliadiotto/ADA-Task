package br.com.ada.pooii.domain;

import br.com.ada.pooii.domain.enums.CurrentStatus;
import br.com.ada.pooii.domain.enums.Priority;

public class StudyTask extends BaseTask{

    private String studySubject;

    public StudyTask(String title, String description, Priority priority, CurrentStatus currentStatus, String studySubject) {
        super(title, description, priority, currentStatus);
        this.studySubject = studySubject;
    }

    public String getStudySubject() {
        return studySubject;
    }

    public void setStudySubject(String studySubject) {
        this.studySubject = studySubject;
    }

    @Override
    public void printTasks() {
        super.printTasks();
        System.out.println("Subject: " + studySubject);
    }
}
