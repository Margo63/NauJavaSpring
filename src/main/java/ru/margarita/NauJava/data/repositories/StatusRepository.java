package ru.margarita.NauJava.data.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.margarita.NauJava.entities.Status;

/**
 * Класс взаимодействия с таблицей статусов
 *
 * @author Margarita
 * @version 1.0
 * @since 2025-10-21
 */
public interface StatusRepository extends CrudRepository<Status, Long> {
}
