package ru.margarita.NauJava.common;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.Scanner;

/**
 * Класс конфигурации для обработки пользовательского ввода
 *
 * @author Margarita
 * @version 1.0
 * @since 2025-10-13
 */
@Configuration
public class ConfigInputData {
    @Value("${app.name}")
    private String appName;
    @Value("${app.version:-1}")
    private int appVersion;
    @PostConstruct
    private void printAppInfo() {
        System.out.println("имя приложения: " + appName + " версия: " + appVersion);
    }
}
