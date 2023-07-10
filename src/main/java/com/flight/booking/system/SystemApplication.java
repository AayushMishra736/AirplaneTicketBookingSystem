package com.flight.booking.system;

import com.flight.booking.system.repository.Userdetailsrepository;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.TopicBuilder;


@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Airticket Booking System.",
				version = "1.0.0",
				description = "This project is for airplane ticket booking.",
				contact = @Contact(
						name = "Mr Aayush",
						email = "Aayushmishra736@gmial.com"
				)
		)
)
public class SystemApplication {
	public static void main(String[] args) {

		SpringApplication.run(SystemApplication.class, args);
	}

	@Bean
	public NewTopic topic() {
		return TopicBuilder.name("myTopic")
				.partitions(10)
				.replicas(1)
				.build();
	}
//
//	@KafkaListener(id = "myId", topics = "myTopic")
//	public void listen(String in) {
//		System.out.println(in);
//	}
}
