package com.ameen.ToDo.Controller;

import com.ameen.ToDo.Model.ToDo;
import com.ameen.ToDo.Service.ToDoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/todos")
@RequiredArgsConstructor
public class ToDoController {

    @Autowired
    private final ToDoService toDoService;


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
    public ToDo gitTodoById(@PathVariable Long id) {
        return toDoService.getDodoById(id);
    }

    @PostMapping("list")
    public ToDo addTodo(@Valid @RequestBody ToDo toDo) {
        return toDoService.addTodos(toDo);
    }

    @DeleteMapping("list/{id}")
    public void removeToDo(@PathVariable Long id) {
        toDoService.removeTodo(id);
    }


}



