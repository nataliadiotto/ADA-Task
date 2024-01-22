package br.com.ada.pooii.domain;

import java.time.LocalDateTime;

public class PersonalTask extends BaseTask{

    public PersonalTask(String title, String description, LocalDateTime createdAt, String priority) {
        super(id, title, description, createdAt, priority);
    }

}
