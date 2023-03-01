package com.example.EazyBanking.config;

import java.util.Arrays;
import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .servers(Arrays.asList(
                        new Server().url("http://localhost:8080")
                ))
                .info(new Info().title("My EazyBanking App")
                                .description("My EazyBanking App 1.0")
                                .contact(new Contact()
                                                 .email("nguyen.hai.dang@icloud.com")
                                                 .name("Derek Nguyen"))
                                .license(new License()
                                                 .name("Apache 2.0")
                                                 .url("http://www.apache.org/licenses/LICENSE-2.0.html"))
                                .version("1.0.0"));
    }
}
