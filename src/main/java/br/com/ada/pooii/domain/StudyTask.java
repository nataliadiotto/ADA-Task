package br.com.ada.pooii.domain;

import java.time.LocalDateTime;
import java.util.Random;

public class StudyTask extends BaseTask{

    private String studySubject;

    public StudyTask(String title, String description, String priority, String studySubject) {
        super(title, description, priority);
        this.studySubject = studySubject;
    }

    public String getStudySubject() {
        return studySubject;
    }

    public void setStudySubject(String studySubject) {
        this.studySubject = studySubject;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Study Subject: " + studySubject + "\n";
    }
}
