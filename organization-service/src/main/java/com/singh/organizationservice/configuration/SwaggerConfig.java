package com.singh.organizationservice.configuration;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.context.annotation.Bean;

@OpenAPIDefinition(
        info=@Info(

                title="Organization Service rest api documentation",
                description="Organization Service rest api documentaion",
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
                description="Spring boot Organization service documentaion",
                url="#"
        )
)
public class SwaggerConfig {

}
