package com.example.demo.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
@Entity
public class Competition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private LocalDate date;
    @ManyToMany
    List<Section> sections;

    public Competition(int id, String name, LocalDate date, List<Section> sections) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.sections = sections;
    }

    public List<Section> getSections() {

        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }

    public Competition() {
    }

    public Competition(int id, String name, LocalDate date) {

        this.id = id;
        this.name = name;
        this.date = date;
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
