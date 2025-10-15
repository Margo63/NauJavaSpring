package ru.margarita.NauJava.data;

import java.util.List;

/**
 * Класс взаимодействия с бд (создание, получение, удаление, обновление, получение всех)
 *
 * @author Margarita
 * @version 1.0
 * @since 2025-10-13
 */
public interface TaskCrudRepository<T, ID>
{
    boolean create(T entity);
    T read(ID id);
    boolean update(T entity);
    boolean delete(ID id);
    List<T> getAll();
}