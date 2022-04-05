package com.example.spring_todo.Controller;


import com.example.spring_todo.Repositorys.TodoRepository;
import com.example.spring_todo.Services.TodoService;
import com.example.spring_todo.entities.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo")
public class TodoController {

    @Autowired
            TodoService todoService;
    @Autowired
             TodoRepository todoRepository;

    List<Todo> Todolist = new ArrayList<>(List.of(
            new Todo("Köpa kattmat", "Köp fyra burkar"),
            new Todo("Handla", "Glöm inte mjölk!")
    ));

    @GetMapping
    public List<Todo> getTodolist(){
        return Todolist;
    }

    @GetMapping("/{id}")
    public Todo getTodoById(@PathVariable("id") int id){
        return Todolist.stream()
                .filter(todo -> todo.getId() == id )
                .findFirst()
                .orElseThrow();
    }

    @PostMapping
    public Todo createTodo(@RequestBody Todo todo){
        Todolist.add(todo);
        return todo;
    }

    @DeleteMapping("/{id}")
    public void deleteTodoById(@PathVariable("id") int id){
        Todolist.removeIf(todo -> todo.getId() == id);
    }

    @PutMapping("/{id}")
    public Todo updateTodoById(@PathVariable("id") int id, @RequestBody Todo changedtodo){
        Todo existingTodo = Todolist.stream()
                .filter(todo -> todo.getId() == id)
                .findFirst()
                .orElseThrow();

        BeanUtils.copyProperties(changedtodo, existingTodo, "id");

        return existingTodo;

    }


}
