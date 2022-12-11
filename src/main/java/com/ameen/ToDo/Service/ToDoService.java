package com.ameen.ToDo.Service;

import com.ameen.ToDo.Model.ToDo;
import com.ameen.ToDo.Repository.ToDoRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor // add Argument Constructor
public class ToDoService {

    @Autowired
    private final ToDoRepository toDoRepository;

    /**
     * Get All ToDos
     * @return List<ToDo>
     */
    public List<ToDo> getTodos() {
        return toDoRepository.findAll();
    }

    public ToDo getDodoById(Long id) {
        boolean isTodoExists = toDoRepository.existsById(id);

        if (!isTodoExists) {
            throw new IllegalStateException(
                    "Todo: " + id + " is not exists! 😲"
            );
        }

        return toDoRepository.findById(id).get();

    }

    public ToDo addTodos(ToDo toDo) {
        return toDoRepository.save(toDo);
        // insert => insert a row in db.
        // save => if the entity found update it, if not insert it
    }


    public void removeTodo(Long id) {
         toDoRepository.deleteById(id);
    }
}

/*
 * ArrayList Arrays.asList List.of();
 *
 * @PathParam & @PathVariable ==> extract query param
 * @RequestParam ==> extract query string
 * @RequestBody
 * ------------
 * ArrayList => mutable (editable)
 * Arrays.asList => immutable (not editable)
 *
 *
 * */
