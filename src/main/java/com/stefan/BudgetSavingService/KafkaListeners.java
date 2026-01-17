package com.stefan.BudgetSavingService;

import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration
public class KafkaListeners {

    @KafkaListener(topics = "BudgetSavingService",groupId = "groupId")
    void listener(String data) {
        System.out.println("Listener Recieved : " + data);
    }
}
