package com.lambdaschool.todos.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "todo")
public class Todo extends Auditable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String description;

    private boolean completed = false;

    @ManyToOne()
    @JoinColumn(name = "userid", nullable = false)
    @JsonIgnoreProperties(value = "todo")
    private User user;

    public Todo()
    {
    }

    public Todo(
        User user,
        String description)
    {
        this.user = user;
        this.description = description;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public boolean isCompleted()
    {
        return completed;
    }

    public void setCompleted(boolean completed)
    {
        this.completed = completed;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    @Override
    public String toString()
    {
        return "Todo{" +
            "todoid=" + id +
            ", description='" + description + '\'' +
            ", completed=" + completed +
            '}';
    }
}
