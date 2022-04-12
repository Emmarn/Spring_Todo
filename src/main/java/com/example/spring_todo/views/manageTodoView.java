/*package com.example.spring_todo.views;

import com.example.spring_todo.Component.Todoform;
import com.example.spring_todo.Repositorys.TodoRepository;
import com.example.spring_todo.Services.TodoService;
import com.example.spring_todo.entities.Todo;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.h2.engine.User;

@Route(value = "/addtodo")
public class manageTodoView extends VerticalLayout {

    Grid<Todo> grid = new Grid<>(Todo.class);
    TodoService todoService;
    Todoform todoform;
    TodoRepository todoRepository;

    public manageTodoView(TodoService todoService, TodoRepository todoRepository) {

        this.todoService = todoService;
        this.todoRepository = todoRepository;
        this.todoform = new Todoform(todoService, this);
        setAlignItems(Alignment.CENTER);
        add(new H2("Modherclucker!"));

        grid.addComponentColumn(todo -> {
            Button button = new Button(new Icon(VaadinIcon.CLOSE), evt -> {
                Notification.show(todo.getTodomessage());
                todoService.deleteTodoById(todo.getId());
                updateItems();
            });

            button.addThemeVariants(
                    ButtonVariant.LUMO_ERROR,
                    ButtonVariant.LUMO_PRIMARY,
                    ButtonVariant.LUMO_SMALL
            );

            return button;
        });

        grid.addColumn(Todo::getId).setHeader("Id").setSortable(true).setResizable(true);
        grid.addColumn(Todo::getTitle).setHeader("Title");
        grid.addColumn(Todo::getTodomessage).setHeader("Todo");
        grid.asSingleSelect().addValueChangeListener(e -> {
            todoform.setTodo(e.getValue());
        });

        HorizontalLayout addTodo = new HorizontalLayout(grid, todoform);
        addTodo.setSizeFull();

        Button button = new Button("New Todo", e -> {
            Dialog dialog = new Dialog();
            Todoform dialogForm = new Todoform(todoService, this);

            Todo todo = new Todo();

            dialogForm.setTodo(todo);

            dialog.add(todoform);
            dialog.open();


        });

        add(addTodo, button);


    }

    public void updateItems() {


    }
}*/


