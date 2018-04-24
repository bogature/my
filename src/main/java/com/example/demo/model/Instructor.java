package com.example.demo.model;

import com.example.demo.enums.DifficultyLevel;
import com.example.demo.enums.TypeOfInstructor;

import javax.persistence.*;

@Entity
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Enumerated(EnumType.STRING)
    private TypeOfInstructor typeOfInstructor;
    @Enumerated(EnumType.STRING)
    private DifficultyLevel difficultyLevel;

    public Instructor() {
    }

    public Instructor(int id, String name, TypeOfInstructor typeOfInstructor, DifficultyLevel difficultyLevel) {

        this.id = id;
        this.name = name;
        this.typeOfInstructor = typeOfInstructor;
        this.difficultyLevel = difficultyLevel;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TypeOfInstructor getTypeOfInstructor() {
        return typeOfInstructor;
    }

    public void setTypeOfInstructor(TypeOfInstructor typeOfInstructor) {
        this.typeOfInstructor = typeOfInstructor;
    }

    public DifficultyLevel getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(DifficultyLevel difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }
}
