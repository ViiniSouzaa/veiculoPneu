package com.project.veiculoPneu.config;

import io.swagger.v3.oas.models.info.*;
import io.swagger.v3.oas.models.ExternalDocumentation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                    .title("API de Veiculos e Pneus")
                    .version("v1.0")
                    .description("Esta é uma API  para gerenciamento de veículos e pneus.")
                )
                .externalDocs(null);
    }
}