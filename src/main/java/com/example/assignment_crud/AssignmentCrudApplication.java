package com.example.assignment_crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class AssignmentCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssignmentCrudApplication.class, args);
	}

}
