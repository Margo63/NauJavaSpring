package ru.margarita.NauJava.common;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;

/**
 * Класс конфигурации OpenApi
 *
 * @author Margarita
 * @version 1.0
 * @since 2025-10-28
 */
public class ConfigOpenApi {
    @Bean
    public GroupedOpenApi usersApi() {
        return GroupedOpenApi.builder()
                .group("users")
                .pathsToMatch("/custom/users/**")
                .build();
    }

    @Bean
    public GroupedOpenApi tasksApi() {
        return GroupedOpenApi.builder()
                .group("tasks")
                .pathsToMatch("/tasks/**")
                .build();
    }
}
