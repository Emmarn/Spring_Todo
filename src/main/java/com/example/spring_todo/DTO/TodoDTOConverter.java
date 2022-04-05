package com.example.spring_todo.DTO;


import com.example.spring_todo.Repositorys.TodoRepository;
import com.example.spring_todo.entities.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoDTOConverter {

   /* @Autowired
    TodoRepository todoRepository;

    public Todo TodoRequestDTOEntity(TodoRequestDTO todoRequestDTO){

        Todo todo = TodoRepository
                .findById(todoRequestDTO.getTodo_id())
                .orElseThrow();

        return new Todo(todoRequestDTO.getTitle(),
                todoRequestDTO.getMessage(),
                todo);

    }

    public TodoDTOConverter entityToTodoResponsDTO(Todo todo) {

        return new TodoRequestDTO(
                todo.getId(),
                todo.getTitle(),
                todo.getTodomessage()
        );

    }*/
}
