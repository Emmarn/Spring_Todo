package com.example.spring_todo.Component;

import com.example.spring_todo.Services.TodoService;
import com.example.spring_todo.entities.Todo;
import com.example.spring_todo.views.manageTodoView;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.Binder;

public class Todoform  extends FormLayout {

    TextField title = new TextField("Title");
    TextArea todomessage = new TextArea("Message");
    Button todoButton = new Button("Ny knapp");

     Binder<Todo> binder = new BeanValidationBinder<>(Todo.class);
     TodoService todoService;
     manageTodoView manageTodoView;

     /*public TodoForm (TodoService todoService, manageTodoView manageTodoView) {
         this.todoService = todoService;
         this.manageTodoView = manageTodoView;
         binder.bindInstanceFields(this);
         setVisible(false);

         todoButton.addClickListener(e -> updateSaveTodo());

         add(title, todomessage, todoButton);


     }

     private void handleSave() {
     Todo todo = binder.validate().getBinder().getBean();
      if(todo.getId() == 0) {
    todoService.save(todo);
     } else {
     todoService.updateById(todo.getId(), todo)
    }
    setTodo(null);
     manageTodoView.updateItems();

     this.getParent().ifPresent(c -> {
     if(c instanceof Dialog) {
     ((Dialoo) c).close();
    }
     });





    public void setTodo(Todo todo) {
        if(todo != null) {
            binder.setBean(todo);
            setVisible(true);
        } else {
            setVisible(false);
        }
    }*/
}
