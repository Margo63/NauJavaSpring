package ru.margarita.NauJava.data.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.margarita.NauJava.entities.Notification;

/**
 * Класс взаимодействия с таблицей уведомлений
 *
 * @author Margarita
 * @version 1.0
 * @since 2025-10-21
 */
public interface NotificationRepository extends CrudRepository<Notification, Long> {
}
