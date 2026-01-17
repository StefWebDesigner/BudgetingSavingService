package com.stefan.BudgetSavingService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class BudgetSavingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BudgetSavingServiceApplication.class, args);
	}

	//For inital Testing
//	@Bean
//	CommandLineRunner runner(KafkaTemplate<String, String> kafkaTemplate) {
//		return args -> {
//			for (int i = 0; i < 10; i++) {
//				kafkaTemplate.send("BudgetSavingService", "Budget Saving Service");
//
//			}
//		};
//	}

}
