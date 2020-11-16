package com.silverfoxmedia.order.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {
    @Bean(name="orderOpenApi")
    public OpenAPI orderOpenApi (){
        return new OpenAPI()
                .components(new Components())
                .info(new Info()
                        .title("Order Application API")
                        .description("Order API implemented with Spring Boot RESTful service and documented using springdoc-openapi and OpenAPI")
                );
    }
}
