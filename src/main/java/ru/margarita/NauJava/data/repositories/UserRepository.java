package ru.margarita.NauJava.data.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.margarita.NauJava.entities.User;
import java.util.List;

/**
 * Класс взаимодействия с таблицей пользователей
 *
 * @author Margarita
 * @version 1.0
 * @since 2025-10-21
 */
public interface UserRepository extends CrudRepository<User, Long>
{
    List<User> findByName(String name);
    List<User> findByEmailAndPassword(String email, String password);
    void deleteByName(String name);
}