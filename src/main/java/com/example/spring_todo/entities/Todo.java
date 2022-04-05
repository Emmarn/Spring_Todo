package com.example.spring_todo.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Todo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String title;

    @Column
    private String todomessage;

    public Todo(String title, String todomessage) {
        this.title = title;
        this.todomessage = todomessage;
    }

    public Todo(int id, String title, String todomessage){
        this.id = id;
        this.title = title;
        this.todomessage = todomessage;
    }

    public Todo() {

    }

    public void setId(int id) {
        this.id=id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTodomessage(String todomessage) {
        this.todomessage = todomessage;
    }

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
