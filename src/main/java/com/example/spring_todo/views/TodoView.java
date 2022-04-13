package com.example.spring_todo.views;

import com.example.spring_todo.Component.Todoform;
import com.example.spring_todo.Services.TodoService;
import com.example.spring_todo.Repositorys.TodoRepository;
import com.example.spring_todo.entities.Todo;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.data.binder.Binder;
import java.awt.*;

@Route("todo")
public class TodoView extends VerticalLayout {

    Grid<Todo> grid = new Grid<>(Todo.class);
    TodoService todoService;
    Todoform todoform;
    //TodoRepository todorepository;

    public TodoView(TodoService todoService, TodoRepository todoRepository){
        this.todoService = todoService;
        //this.todorepository = todoRepository;
        this.todoform = new Todoform(todoService, this);
        setAlignItems(Alignment.CENTER);
        setSizeFull();

        H1 cykelTjuv = new H1("VEM TOG MIN KEXCHOKLAD GJORD AV EN CYKELPUMP");

       HorizontalLayout mainContent = new HorizontalLayout(grid, todoform);
       mainContent.setSizeFull();

        Button button = new Button("Ny todo",evt-> {
            Dialog dialog = new Dialog();
            Todoform dialogForm = new Todoform(todoService, this);
            dialogForm.setTodo(new Todo());
            //Todo todo = new Todo();

            //dialogForm.setTodo(todo);

            dialog.add(dialogForm);
            dialog.open();
            //todoform.setVisible(true);
        });
        Paragraph pa = new Paragraph("Jari och Tor är samma, dom har en hammare båda två, men jari är lite coolare");

        setupGrid();
        add(cykelTjuv, grid, button, pa);
        updateGridItems();
    }

    public void setupGrid(){
        grid.setSizeFull();
        grid.setColumns("title", "todomessage");
        grid.getColumnByKey("title").setHeader("Rubrik");
        grid.getColumnByKey("todomessage").setHeader("Uppgift");
        Grid.Column<Todo> editColumn =  grid.addComponentColumn(todo -> {
            Button editBtn = new Button("Edit");
            editBtn.addClickListener(evt -> {
                if(grid.getEditor().isOpen())
                    grid.getEditor().cancel();
                grid.getEditor().editItem(todo);
            });
            return editBtn;
        });

        Binder<Todo> binder = new Binder <>(Todo.class);
        grid.getEditor().setBinder(binder);

        TextField titleField = new TextField();
        titleField.setWidthFull();
        binder.forField(titleField)
                .asRequired("Kan inte vara tom")
                .bind(Todo::getTitle, Todo::setTitle);
        grid.getColumnByKey("title").setEditorComponent(titleField);

        TextField uppgiftField = new TextField();
        uppgiftField.setWidthFull();
        binder.forField(uppgiftField)
                .asRequired("Kan inte vara tom")
                .bind(Todo::getTodomessage, Todo::setTodomessage);
        grid.getColumnByKey("todomessage").setEditorComponent(uppgiftField);

        Button saveBtn = new Button("Save", evt -> grid.getEditor().save());
        Button cancelBtn = new Button(VaadinIcon.CLOSE_CIRCLE.create(), evt -> grid.getEditor().cancel());

        //Testa
        Button deleteBtn = new Button("Delete", evt -> {
            todoService.deleteTodoById(grid.getEditor().getItem().getId());
            updateGridItems();
        });

        cancelBtn.addThemeVariants(ButtonVariant.LUMO_ICON, ButtonVariant.LUMO_ERROR);
        HorizontalLayout btnLayout = new HorizontalLayout(saveBtn, deleteBtn, cancelBtn);

        editColumn.setEditorComponent(btnLayout);
    }

    public void addTodo(Todo todo){
        if(todo == null){

        }
    }

    public void deleteItemAndUpdate(){

    }

    public void updateGridItems(){
        grid.setItems(todoService.findAll());
    }

    public void updateItems() {
        grid.setItems((todoService.findAll()));
    }


}
