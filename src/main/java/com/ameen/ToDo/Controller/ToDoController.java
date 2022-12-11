package com.ameen.ToDo.Controller;

import com.ameen.ToDo.Model.ToDo;
import com.ameen.ToDo.Service.ToDoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<ToDo>> getTodos() {
        List<ToDo> result = toDoService.getTodos();

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("list/{id}")
    public ResponseEntity<ToDo> gitTodoById(@PathVariable Long id) {
        ToDo result = toDoService.getDodoById(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("list")
    public ResponseEntity<ToDo> addTodo(@Valid @RequestBody ToDo toDo) {
        ToDo result = toDoService.addTodos(toDo);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @DeleteMapping("list/{id}")
    public ResponseEntity<Void> removeToDo(@PathVariable Long id) {
        toDoService.removeTodo(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}



