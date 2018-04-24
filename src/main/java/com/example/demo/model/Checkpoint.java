package com.example.demo.model;

import javax.persistence.*;

@Entity
public class Checkpoint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @ManyToOne
    private Route route;

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

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public Checkpoint(int id, String name, Route route) {

        this.id = id;
        this.name = name;
        this.route = route;
    }

    public Checkpoint() {

    }
}
