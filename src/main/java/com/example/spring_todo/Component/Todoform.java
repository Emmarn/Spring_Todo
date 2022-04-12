package com.example.spring_todo.Component;

import com.example.spring_todo.Services.TodoService;
import com.example.spring_todo.entities.Todo;
import com.example.spring_todo.views.Route;
import com.example.spring_todo.views.TodoView;
/*import com.example.spring_todo.views.manageTodoView;*/
import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;

public class Todoform  extends FormLayout {


    TextField title = new TextField("Title");
    TextArea todomessage = new TextArea("Message");
    Button todoButton = new Button("Spara");

     Binder<Todo> binder = new BeanValidationBinder<>(Todo.class);
     TodoService todoService;
     /*manageTodoView manageTodoView;*/
     TodoView todoView;

    /*public Todoform(TodoService todoService, TodoView todoView) {
    }*/

    /*public Todoform(TodoService todoService, com.example.spring_todo.views.manageTodoView manageTodoView) {
    }*/


    public Todoform (TodoService todoService, TodoView todoView) {
         this.todoService = todoService;
         this.todoView = todoView;
         binder.bindInstanceFields(this);
         setVisible(true);


         todoButton./*addAttachListener*/addClickListener(e ->
                 updateSaveTodo());

         add(title, todomessage, todoButton);


     }

     private void updateSaveTodo() {
       //  Todo testTodo = new Todo("Tetet", "asdasd");
       // todoService.save(testTodo);
         Todo todo = binder.validate().getBinder().getBean();


         if (todo.getId() == 0) {
             todoService.save(todo);
         } else {
             todoService.updateById(todo.getId(), todo);
         }
         setTodo(null);

         //todoService.createTodo(Todoform.);


        // todoService.save(new Todo(todo.getTitle(), todo.getTodomessage()));
         /*setTodo(null);*/

         todoView.updateItems();

         this.getParent().ifPresent(c -> {
             if (c instanceof Dialog) {
                 ((Dialog) c).close();
             }
         });
     }

    public void setTodo(Todo todo) {
        if(todo != null) {
            binder.setBean(todo);
            setVisible(true);
        } else {
            setVisible(false);
        }
    }

}
