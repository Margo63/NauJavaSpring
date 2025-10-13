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
    @Autowired
    private CommandProcessor commandProcessor;

    @PostConstruct
    private void printAppInfo() {
        System.out.println("имя приложения: " + appName + " версия: " + appVersion);
    }

    @Bean
    public CommandLineRunner commandScanner() {
        return args ->
        {
            try (Scanner scanner = new Scanner(System.in)) {
                System.out.println("Введите команду. 'exit' для выхода.\n'info' для получении информации о всех командах.");
                while (true) {
                    // Показать приглашение для ввода
                    System.out.print("> ");
                    String input = scanner.nextLine();
                    // Выход из цикла, если введена команда "exit"
                    if ("exit".equalsIgnoreCase(input.trim())) {
                        System.out.println("Выход из программы...");
                        break;
                    }
                    // Обработка команды
                    commandProcessor.processCommand(input);
                }
            }
        };
    }
}
