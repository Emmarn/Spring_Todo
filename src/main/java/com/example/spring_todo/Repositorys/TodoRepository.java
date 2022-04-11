package com.example.spring_todo.Repositorys;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.spring_todo.entities.Todo;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer> {
       //List<Todo> findByTodo_title(String title);


}
