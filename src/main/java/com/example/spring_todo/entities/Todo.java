package com.example.spring_todo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Todo implements Serializable {

    @Id
    @Column
    static int idCounter = 1;
    @Column
    private int id;
    @Column
    private String title;
    @Column
    private String todomessage;

    public Todo(String title, String todomessage) {
        this.id = idCounter;
        this.title = title;
        this.todomessage = todomessage;
        idCounter++;
    }

    public Todo() {

    }

    public static void setIdCounter(int idCounter) {
        Todo.idCounter = idCounter;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTodomessage(String todomessage) {
        this.todomessage = todomessage;
    }

    public static int getIdCounter() {
        return idCounter;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Id
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getTodomessage() {
        return todomessage;
    }

}
