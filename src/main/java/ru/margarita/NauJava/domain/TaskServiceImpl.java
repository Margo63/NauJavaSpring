package ru.margarita.NauJava.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.margarita.NauJava.data.TaskCrudRepository;
import ru.margarita.NauJava.data.TaskRepository;
import ru.margarita.NauJava.model.Task;
import java.util.List;

/**
 * Реализация {@link TaskService}
 *
 * @author Margarita
 * @version 1.0
 * @since 2025-10-13
 */
@Service
public class TaskServiceImpl implements TaskService
{
    private final TaskCrudRepository<Task,Long> taskRepository;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository)
    {
        this.taskRepository = taskRepository;
    }

    @Override
    public boolean createTask(Long id, String title, String description) {
        Task newTask = new Task(id, title, description);
        return taskRepository.create(newTask);
    }

    @Override
    public Task findById(Long id)
    {
        return taskRepository.read(id);
    }

    @Override
    public boolean deleteById(Long id)
    {
        return taskRepository.delete(id);
    }

    @Override
    public boolean updateTitle(Long id, String newTitle) {
        Task task = findById(id);
        task.setTitle(newTitle);
        return taskRepository.update(task);
    }

    @Override
    public List<Task> getAll() {
        return taskRepository.getAll();
    }
}
