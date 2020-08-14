package com.lambdaschool.todos.services;

import com.lambdaschool.todos.models.Todo;
import com.lambdaschool.todos.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Transactional
@Service(value = "todosService")
public class TodosServiceImpl implements TodosService
{
    @Autowired
    private TodoRepository todoRepository;

    @Transactional
    @Override
    public void markComplete(long todoid)
    {
        Todo completedtodo = todoRepository.findById(todoid)
            .orElseThrow(() -> new EntityNotFoundException("Todo " + todoid + " Not found"));
        completedtodo.setCompleted(true);
    }

    @Transactional
    @Override
    public Todo findById(long id)
    {
        Todo myTodo = todoRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Todo " + id + " Not Found"));
        return myTodo;
    }

}
