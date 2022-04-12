package com.example.spring_todo.Services;


import com.example.spring_todo.Repositorys.TodoRepository;
import com.example.spring_todo.entities.Todo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoService{

    TodoRepository todoRepository;
    private Todo todo;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    List<Todo> todoList = new ArrayList<>(List.of(
            new Todo( "Köpa kattmat", "Köp fyra burkar"),
            new Todo( "Handla", "Glöm inte mjölk!")
    ));

    public List<Todo> findAll() {
        //return todoRepository.findAll();
        return todoList;
    }

    public Todo findById(int id){
        return todoRepository.findById(id).orElseThrow();
    }

    public void deleteTodoById(int id) {
        //todoRepository.deleteById(id);
        todoList.removeIf(todo -> todo.getId() == id);

    }

    public void createTodo(Todo todo) {
        todoRepository.save(todo);

       /*int index = todoList.lastIndexOf();

       Todo newIndex = todoList.get(index);
       int id = newIndex.getId()+1;*/


        /*int maxId = 0;
        for (int i = 0; i < todoList.size(); i++) {
            if (maxId < todoList.get(i).getId()) {
                maxId = todoList.get(i).getId();
            }
        }
        int id = maxId + 1;

        todoList.add(new Todo(id, todo.getTitle(), todo.getTodomessage()));*/
    }

    public Todo getTodoByid(int id) {
        return todoRepository.getById(id);
    }

    public Todo save(Todo todo) {
        return todoRepository.save(todo);
    }

    public Todo getTodo(){
        return todo;
    }

    public Todo updateById(int id, Todo updatedTodo) {

        Todo activeTodo = todoRepository.findById(id).orElseThrow();

        if(updatedTodo.getTitle() != null)
            activeTodo.setTitle(updatedTodo.getTitle());
        if(updatedTodo.getTodomessage() != null)
            activeTodo.setTodomessage(updatedTodo.getTodomessage());

        todoRepository.save(updatedTodo);

        return activeTodo;

    }
}
