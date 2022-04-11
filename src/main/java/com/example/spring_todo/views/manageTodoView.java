package com.example.spring_todo.views;

import com.example.spring_todo.Component.Todoform;
import com.example.spring_todo.Repositorys.TodoRepository;
import com.example.spring_todo.Services.TodoService;
import com.example.spring_todo.entities.Todo;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "/manageTodoView")
public class manageTodoView extends VerticalLayout {

    Grid<Todo> grid = new Grid<>(Todo.class);
    TodoService todoService;
    Todoform todoform;
    TodoRepository todoRepository;

    public manageTodoView(TodoService todoService, TodoRepository todoRepository) {

        this.todoService = todoService;
        this.todoRepository = todoRepository;
        this.todoform = new Todoform();
        setAlignItems(Alignment.CENTER);

        grid.addComponentColumn(todo -> {
            Button button = new Button(new Icon(VaadinIcon.CLOSE), evt -> {
                Notification.show(todo.getTodomessage());
            } );
            return button;
    });
};

    public void updateItems() {
    }
}
