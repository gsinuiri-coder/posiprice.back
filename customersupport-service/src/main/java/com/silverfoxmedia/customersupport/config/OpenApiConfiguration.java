package com.silverfoxmedia.customersupport.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {
    @Bean(name="customersupportOpenApi")
    public OpenAPI bloggingOpenApi (){
        return new OpenAPI()
                .components(new Components())
                .info(new Info()
                        .title("Customer Support Application API")
                        .description("Customer Support API implemented with Spring Boot RESTful micro-service and documented using springdoc-openapi and OpenAPI")
                );
    }
}
