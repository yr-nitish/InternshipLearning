package com.example.ServerS1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ServerS1Application {

	public static void main(String[] args) {
		SpringApplication.run(ServerS1Application.class, args);
	}

}
