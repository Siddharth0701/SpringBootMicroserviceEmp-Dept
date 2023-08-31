package com.singh.departmentservice;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info=@Info(

				title="Department Service rest api documentation",
				description="Department Service rest api documentaion",
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
				description="Spring boot department service documentaion",
				url="#"
		)
)
public class DepartmentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DepartmentServiceApplication.class, args);
	}

}
