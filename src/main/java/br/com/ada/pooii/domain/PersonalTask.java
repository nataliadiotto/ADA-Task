package br.com.ada.pooii.domain;

import java.time.LocalDateTime;
import java.util.Random;

public class PersonalTask extends BaseTask{

    private String category;

    public PersonalTask(String title, String description, Priority priority, CurrentStatus currentStatus, String category) {
        super(title, description, priority, currentStatus);
        this.category = category;

    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
