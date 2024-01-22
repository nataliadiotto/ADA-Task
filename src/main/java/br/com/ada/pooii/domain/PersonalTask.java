package br.com.ada.pooii.domain;

import java.time.LocalDateTime;
import java.util.Random;

public class PersonalTask extends BaseTask{

    public PersonalTask(String title, String description, String priority) {
        super(title, description, priority);
       // super.getId() = new Random();
    }
}
