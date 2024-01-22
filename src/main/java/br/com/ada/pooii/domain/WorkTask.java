package br.com.ada.pooii.domain;

import java.time.LocalDateTime;

public class WorkTask extends BaseTask{

    public WorkTask(String title, String description, LocalDateTime createdAt, String priority) {
        super(id, title, description, createdAt, priority);
    }

}
