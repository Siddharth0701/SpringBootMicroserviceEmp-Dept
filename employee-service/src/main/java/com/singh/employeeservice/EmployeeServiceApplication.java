package com.singh.employeeservice;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
@OpenAPIDefinition(
		info=@Info(

				title="Employee Service rest api documentation",
				description="Employee Service rest api documentaion",
				version="v1.0",
				contact=@Contact(
						name="Siddharth",
						email="siddharth.singh0701@gmail.com",
						url="https://siddhartsingh.netlify.app/"
				),
				license = @License(
						name="Apache 2.0",
						url="#"
				)
		),
		externalDocs = @ExternalDocumentation(
				description="Spring boot Employee service documentaion",
				url="#"
		)
)
@SpringBootApplication

public class EmployeeServiceApplication {
//	@Bean
//	public RestTemplate restTemplate(){
//		return  new RestTemplate();
//	}
	@Bean
	public WebClient webClient(){
		return WebClient.builder().build();
	}

	public static void main(String[] args) {
		SpringApplication.run(EmployeeServiceApplication.class, args);
	}

}
