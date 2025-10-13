package ru.margarita.NauJava.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ru.margarita.NauJava.domain.TaskService;
import ru.margarita.NauJava.model.Task;

/**
 * Реализация {@link CommandInterface}
 *
 * @author Margarita
 * @version 1.0
 * @since 2025-10-13
 */
@Component
public class CommandProcessor implements CommandInterface {
    private final TaskService taskService;
    private final RestTemplate restTemplate = new RestTemplate();
    @Value("${server.port}")
    private int port;

    @Autowired
    public CommandProcessor(TaskService taskService) {
        this.taskService = taskService;
    }

    @Override
    public void processCommand(String input) {
        String[] cmd = input.split(" ");
        switch (cmd[0].toLowerCase()) {
            case "create" -> {
                if (cmd.length != 4) {
                    System.out.println("Не верное количество параметров, дополнительная информация info");
                    break;
                }
                if (taskService.createTask(Long.valueOf(cmd[1]), cmd[2], cmd[3]))
                    System.out.println("Задача успешно добавлена...");
                else
                    System.out.println("Задача с данным id уже существует, для обновления используйте update...");
            }
            case "find" -> {
                if (cmd.length != 2) {
                    System.out.println("Не верное количество параметров, дополнительная информация info");
                    break;
                }
                Task task = taskService.findById(Long.valueOf(cmd[1]));
                if (task == null)
                    System.out.println("Задачи с данным id не существует...");
                else
                    System.out.println("Задача '" + task.getTitle() + "' успешно найдена...");
            }
            case "delete" -> {
                if (cmd.length != 2) {
                    System.out.println("Не верное количество параметров, дополнительная информация info");
                    break;
                }
                if (taskService.deleteById(Long.valueOf(cmd[1])))
                    System.out.println("Задача успешно удалена...");
                else
                    System.out.println("Задачи по данному id не существует, она не может быть удалена...");
            }
            case "update" -> {
                if (cmd.length != 3) {
                    System.out.println("Не верное количество параметров, дополнительная информация info");
                    break;
                }
                if (taskService.updateTitle(Long.valueOf(cmd[1]), cmd[2]))
                    System.out.println("Задача успешно обновлена...");
                else
                    System.out.println("Введен не выерный id, задача не может быть обновлена...");
            }
            case "all" -> System.out.println(taskService.getAll().toString());
            case "info" -> System.out.println("""
                    exit -> выход из программы
                    create {id title description} -> создание новой задачи
                    find {id} -> нахождение задачи по индексу
                    delete {id} -> удаление задачи по индексу
                    update {id title} -> обновление заголовка задачи по индексу
                    all -> вывод всех задач
                    actuator {metric} -> получение данных по заданной метрике"""
            );
            case "actuator" -> {
                if (cmd.length != 2) {
                    System.out.println("Не верное количество параметров, дополнительная информация info");
                    break;
                }
                String url = "http://localhost:"+port+"/actuator/" + cmd[1];

                try {
                    String response = restTemplate.getForObject(url, String.class);
                    System.out.println("Ответ по пути " + cmd[1] + ":");
                    System.out.println(response);
                } catch (Exception e) {
                    System.out.println("Ошибка при получении данных с " + url + ": " + e.getMessage());
                }
            }
            default -> System.out.println("Введена неизвестная команда...");
        }
    }
}