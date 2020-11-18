package com.silverfoxmedia.product.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {
    @Bean(name="productOpenApi")
    public OpenAPI productOpenApi (){
        return new OpenAPI()
                .components(new Components())
                .info(new Info()
                        .title("Product Application API")
                        .description("Product API implemented with Spring Boot RESTful service and documented using springdoc-openapi and OpenAPI")
                );
    }
}
