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

@Controller
@RequestMapping("/todo")
public class TodoController {

    @Autowired
            TodoService todoService;
    @Autowired
             TodoRepository todoRepository;



    @GetMapping
    public String getTodolist(Model model){
        List<Todo> todoList = todoService.findAll();
        model.addAttribute("todoList", todoList);
        return "Todo";
    }

    @GetMapping("/addToDoForm")
    public  String addToDo(){return "NewTodoForm";}

    @GetMapping("/{id}")
    public Todo getTodoById(@PathVariable("id") int id){
       return todoService.getTodoByid(id);
        /* return Todolist.stream()
                .filter(todo -> todo.getId() == id )
                .findFirst()
                .orElseThrow();*/
    }

    @PostMapping
    public String createTodo(@ModelAttribute Todo todo){
        todoService.createTodo(todo); //todoService.save(todo)
        return "redirect:/todo";
        //Todolist.add(todo);
       // return todo;

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodoById(@PathVariable("id") int id){
        todoService.deleteTodoById(id);
        return ResponseEntity.status(303).header("Location", "/todo").build();
        //Todolist.removeIf(todo -> todo.getId() == id);
    }

    /*@PutMapping("/{id}")
    public Todo updateTodoById(@PathVariable("id") int id, @RequestBody Todo changedtodo){
        Todo existingTodo = Todolist.stream()
                .filter(todo -> todo.getId() == id)
                .findFirst()
                .orElseThrow();

        BeanUtils.copyProperties(changedtodo, existingTodo, "id");

        return existingTodo;

    }*/


}
