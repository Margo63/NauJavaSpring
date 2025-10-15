package ru.margarita.NauJava.data;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.margarita.NauJava.model.Task;
import java.util.List;
import java.util.Objects;

/**
 * Реализация {@link TaskCrudRepository}
 *
 * @author Margarita
 * @version 1.0
 * @since 2025-10-13
 */
@Component
public class TaskRepository implements TaskCrudRepository<Task, Long>
{
    private final List<Task> taskContainer;

    @Autowired
    public TaskRepository(List<Task> taskContainer)
    {
        this.taskContainer = taskContainer;
    }

    @Override
    public boolean create(Task task)
    {
        if(taskContainer.stream()
                .filter(obj -> Objects.equals(obj.getId(), task.getId())).
                findFirst().orElse(null) == null){
            taskContainer.add(task);
            return true;
        }
       return false;
    }

    @Override
    public Task read(Long id)
    {
        return taskContainer.stream().filter(obj -> Objects.equals(obj.getId(), id)).findFirst().orElse(null);
    }

    @Override
    public boolean update(Task task)
    {
        int ind = taskContainer.indexOf(task);
        if(ind == -1) return false;
        taskContainer.set(ind,task);
        return true;
    }

    @Override
    public boolean delete(Long id)
    {
        Task task = taskContainer.stream()
                .filter(obj -> Objects.equals(obj.getId(), id)).
                findFirst().orElse(null);
        if(task == null){
            return false;
        }
        taskContainer.remove(task);
        return true;
    }

    @Override
    public List<Task> getAll() {
        return taskContainer;
    }
}