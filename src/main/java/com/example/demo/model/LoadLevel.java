package com.example.demo.model;

import javax.persistence.*;

@Entity
public class LoadLevel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @ManyToOne
    private Schedule schedule;

    public LoadLevel() {
    }

    public LoadLevel( String name, Schedule schedule) {
        this.name = name;
        this.schedule = schedule;
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

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }
}
