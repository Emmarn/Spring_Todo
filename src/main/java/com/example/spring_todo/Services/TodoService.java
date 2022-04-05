package com.example.spring_todo.Services;


import com.example.spring_todo.Repositorys.TodoRepository;
import com.example.spring_todo.entities.Todo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoService {

    TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    List<Todo> todoList = new ArrayList<>(List.of(
            new Todo(1, "Köpa kattmat", "Köp fyra burkar"),
            new Todo(2, "Handla", "Glöm inte mjölk!")
    ));

    public List<Todo> findAll() {
        //return todoRepository.findAll();
        return todoList;
    }

    public void deleteTodoById(int id) {
        //todoRepository.deleteById(id);
        todoList.removeIf(todo -> todo.getId() == id);

    }

    public void createTodo(Todo todo) {
        //todoRepository.save(todo);

       /*int index = todoList.lastIndexOf();

       Todo newIndex = todoList.get(index);
       int id = newIndex.getId()+1;*/


        int maxId = 0;
        for (int i = 0; i < todoList.size(); i++) {
            if (maxId < todoList.get(i).getId()) {
                maxId = todoList.get(i).getId();
            }
        }
        int id = maxId + 1;

        todoList.add(new Todo(id, todo.getTitle(), todo.getTodomessage()));
    }

    public Todo getTodoByid(int id) {
        return todoRepository.getById(id);
    }
}
