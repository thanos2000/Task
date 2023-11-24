package com.example.Student.mang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Spring Boot REST API Documentation", description = "Spring Boot REST API Documentation", version = "v1.0", contact = @Contact(name = "Gautham", email = "gautham@gmail.com "), license = @License(name = "Apache 2.0")), externalDocs = @ExternalDocumentation(description = "Spring Boot Student Management Documentation"))
public class StudentMangApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentMangApplication.class, args);
	}

}
