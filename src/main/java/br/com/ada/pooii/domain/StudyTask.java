package br.com.ada.pooii.domain;

import java.time.LocalDateTime;

public class StudyTask extends BaseTask{

    private String studySubject;

    public StudyTask(String title, String description, LocalDateTime createdAt, String priority) {
        super(id, title, description, createdAt, priority);
        this.studySubject = studySubject;
    }

    public String getStudySubject() {
        return studySubject;
    }

    public void setStudySubject(String studySubject) {
        this.studySubject = studySubject;
    }
}
