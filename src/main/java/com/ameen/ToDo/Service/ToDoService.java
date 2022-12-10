package com.ameen.ToDo.Service;

import com.ameen.ToDo.Controller.ToDo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ToDoService {

    // ArrayList => mutable (editable)
    // Arrays.asList => immutable (not editable)
    private final List<ToDo> todoList = new ArrayList<>(
            Arrays.asList(
                    new ToDo(1, "Go to Gym Ya Wala", "Do Body Exercise"),
                    new ToDo(2, "Go to Gym", "Do Body Exercise"),
                    new ToDo(3, "Go to Gym", "Do Body Exercise")
            )
    );

    public List<ToDo> getTodos() {
        return todoList;
    }

    public ToDo getDodoById(int id) {
        for (ToDo todo : todoList) {
            if (todo.getId() == id) return todo;
        }

        return null;
    }

    public Boolean addTodos(ToDo toDo) {
        return todoList.add(toDo); // returns Boolean
    }

    public void delete(int id) {

        todoList.removeIf(toDo -> toDo.getId() == id);

        // for (ToDo toDo: todoList) { if (toDo.getId() == id) todoList.remove(toDo); }
    }
}

/*
 * ArrayList Arrays.asList List.of();
 *
 * @PathParam & @PathVariable ==> extract query param
 * @RequestParam ==> extract query string
 * @RequestBody
 *
 *
 *
 * */
