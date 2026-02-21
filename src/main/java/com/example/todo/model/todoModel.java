package com.example.todo.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
public class todoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private boolean completed;

    public todoModel(){}
    public todoModel(String title){
        this.title = title;
        this.completed = false;
    }
}
