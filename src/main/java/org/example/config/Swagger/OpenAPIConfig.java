package org.example.config.Swagger;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// http://localhost:8080/swagger-ui/index.html
@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI financeOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Finance API")
                        .version("1.0")
                        .description("API zur Verwaltung von Assets mit Spring Boot und MongoDB"));
    }
}
