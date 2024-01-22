package br.com.ada.pooii.domain;

import java.time.LocalDateTime;
import java.util.Random;

public class StudyTask extends BaseTask{

    private String studySubject;

    public StudyTask(String title, String description, String priority) {
        super(title, description, priority);
    }

    public String getStudySubject() {
        return studySubject;
    }

    public void setStudySubject(String studySubject) {
        this.studySubject = studySubject;
    }
}
