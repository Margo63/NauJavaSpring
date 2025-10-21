package ru.margarita.NauJava.data.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.margarita.NauJava.entities.Category;

/**
 * Класс взаимодействия с таблицей категорий
 *
 * @author Margarita
 * @version 1.0
 * @since 2025-10-21
 */
public interface CategoryRepository extends CrudRepository<Category, Long> {
}
