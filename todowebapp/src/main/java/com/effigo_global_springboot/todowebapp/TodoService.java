package com.effigo_global_springboot.todowebapp;

import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class TodoService {
    private static List<ToDo> todos = new ArrayList<>();
    private static int todosCount=0;

    static {
        todos.add(new  ToDo(todosCount++,"effigo","Java", LocalDate.now().plusYears(1),false));
        todos.add(new  ToDo(todosCount++,"effigo","dsa", LocalDate.now().plusYears(2),false));
    }

    public List<ToDo> findByUsername(String username)
    {
        Predicate<? super ToDo> predicate
                =toDo -> toDo.getUsername().equalsIgnoreCase(username);
        return todos.stream().filter(predicate).toList();
    }

    public void addTodo(String username, String description, LocalDate targetDate, boolean done)
    {
        ToDo toDo=new ToDo(todosCount++,username,description,targetDate,done);
        todos.add(toDo);
    }

    public void deleteById(int id)
    {
        // todo.getId() ==id

        Predicate<? super ToDo> predicate
                =toDo -> toDo.getId()==id;
        todos.removeIf(predicate);
    }

    public ToDo findById(int id) {

        Predicate<? super ToDo> predicate
                =toDo -> toDo.getId()==id;
        ToDo toDo = todos.stream().filter(predicate).findFirst().get();
        return toDo;
    }

    public void updateTodo(@Valid ToDo toDo) {
        deleteById(toDo.getId());
        todos.add(toDo);
    }
}
