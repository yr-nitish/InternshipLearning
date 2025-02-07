package com.ateffigo.learn_spring_security.Resources;

import jakarta.annotation.security.RolesAllowed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoResource {
    private Logger logger = LoggerFactory.getLogger(getClass());
    List<Todo> todoList = List.of(new Todo("nitish", "Learn AWS"),
            new Todo("nitish", "Learn DSA"),
            new Todo("nitish", "Learn Java"));
    @GetMapping("todos")
    public List<Todo> retrieveAllTodos(){

        return todoList;
    }

    @GetMapping("/users/{username}/todos")
    @PreAuthorize("hasRole('USER') and #username == authentication.name")
    @PostAuthorize("returnObject.username =='nitish")
    @RolesAllowed({"ADMIN", "USER"})
    public Todo retrieveTodosForASpecificUser(@PathVariable String username){

        return todoList.get(0);

    }
    @PostMapping("/users/{username}/todos")
    public void createTodosForASpecificUser(@PathVariable String username, @RequestBody Todo todo){

        logger.info("Create {} for {}",todo,username);

    }
    record Todo(String username,String description){}

}