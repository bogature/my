package com.example.demo.model;

import javax.persistence.*;

@Entity(name = "groups")
public class Groups {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @ManyToOne
    private Section section;
    @ManyToOne
    private Coach coach;

    public Groups() {
    }

    public Groups(int id, String name, Section section, Coach coach) {

        this.id = id;
        this.name = name;
        this.section = section;
        this.coach = coach;
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

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public Coach getCoach() {
        return coach;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }
}
