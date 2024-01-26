package br.com.ada.pooii.domain;

import java.time.LocalDateTime;
import java.util.Random;

public class StudyTask extends BaseTask{

    private String studySubject;

    public StudyTask(String title, String description, Priority priority) {
        super(title, description, priority);
    }

}
