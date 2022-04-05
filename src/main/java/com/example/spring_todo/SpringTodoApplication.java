package com.example.spring_todo;

import com.example.spring_todo.Repositorys.TodoRepository;
import com.example.spring_todo.entities.Todo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringTodoApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringTodoApplication.class, args);
    }

   /* @Bean

    CommandLineRunner init(TodoRepository todoRepository){
        return args->{
            Todo todo=new Todo("Städa", "Städa i badrummet");
            todoRepository.save(todo);
        };
    }*/

}
