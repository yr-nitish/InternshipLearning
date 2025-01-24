package com.effigo_global_springboot.todowebapp;

import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;
import java.util.List;

@Controller
@SessionAttributes("name")
public class ToDoController {

    private TodoService todoService;

    public ToDoController(TodoService todoService) {
        super();
        this.todoService=todoService;
    }

    @RequestMapping("list-todos")
    public String listAlltodos(ModelMap model)
    {
        String username = getLoggedinUsername(model);
        System.out.println(username);
        List<ToDo> todos = todoService.findByUsername(username);
        model.addAttribute("todos", todos);
        return "ListTodos";
    }

    private static String getLoggedinUsername(ModelMap model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }

    @RequestMapping(value = "add-todo", method = RequestMethod.GET)
    public String showNewTodoPage(ModelMap model)
    {
        String username = getLoggedinUsername(model);
        ToDo toDo=new ToDo(0,username,"",LocalDate.now().plusYears(1),false);
        model.put("toDo", toDo);
        return "todo";
    }

    @RequestMapping(value = "add-todo", method = RequestMethod.POST)
    public String addTodo(ModelMap model, @Valid ToDo toDo, BindingResult result)
    {
        if(result.hasErrors())
        {
            return  "todo";
        }
        String username = getLoggedinUsername(model);
//        System.out.println(username);
        todoService.addTodo(username,toDo.getDescription(), toDo.getTargetDate(),false);
        return "redirect:list-todos";
    }

    @RequestMapping("delete-todo")
    public String deleteTodo(@RequestParam int id)
    {
        // Delete todo

        todoService.deleteById(id);
        return "redirect:list-todos";
    }

    @RequestMapping(value = "update-todo", method = RequestMethod.GET)
    public String showUpdateTodoPage(@RequestParam int id, ModelMap model)
    {
        // Update todo
        ToDo toDo = todoService.findById(id);
        model.addAttribute("toDo",toDo);
        return "todo";
    }


    @RequestMapping(value = "update-todo", method = RequestMethod.POST)
    public String updateTodo(ModelMap model, @Valid ToDo toDo, BindingResult result)
    {
        if(result.hasErrors())
        {
            return  "todo";
        }
        String username = getLoggedinUsername(model);
        toDo.setUsername(username);
        todoService.updateTodo(toDo);
        return "redirect:list-todos";
    }
}
