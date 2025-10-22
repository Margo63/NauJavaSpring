package ru.margarita.NauJava.entities;

import jakarta.persistence.*;
import java.util.Date;

/**
 * описание задачи
 *
 * @author Margarita
 * @version 1.0
 * @since 2025-10-21
 */

@Entity
@Table(name = "tbl_task")
public class Task
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String title;
    @Column
    private String description;
    @Column
    private Date dueDate;
    @Column
    private int timer;

    @ManyToOne
    private User user;

    public Task() {
    }

    public Task(String title, User user) {
        this.title = title;
        this.user = user;
    }

    public Long getId()
    {
        return id;
    }
    public void setId(Long id)
    {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public int getTimer() {
        return timer;
    }

    public void setTimer(int timer) {
        this.timer = timer;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}


