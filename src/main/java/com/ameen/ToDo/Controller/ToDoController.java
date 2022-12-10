package com.ameen.ToDo.Controller;

import com.ameen.ToDo.Service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/todos")
public class ToDoController {

    @Autowired
    private ToDoService toDoService;


    @RequestMapping(value = {"", "/"}) //@GetMapping
    public String greeting() {
        return "Welcome Ya Man 💪😍, That is great.";

    }

    @GetMapping("/{name}")
    public String greetingWithName(@PathVariable String name) {
        return String.format("Welcome %s in my website", name);
    }


    @GetMapping("list")
    public List<ToDo> getTodos() {
        return toDoService.getTodos();
    }

    @GetMapping("list/{id}")
    public ToDo gitTodoById(@PathVariable int id) {
        return toDoService.getDodoById(id);
    }

    @PostMapping("list")
    public ToDo addTodo(@RequestBody ToDo toDo) {
        //return toDoService.addTodos(toDo);

        if (toDoService.addTodos(toDo)) {
            return toDo;
        }

        return null;
    }

    @DeleteMapping("list/{id}")
    public void removeToDo(@PathVariable int id) {
        toDoService.delete(id);
    }


}



