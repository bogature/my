package com.example.demo.model;

import com.example.demo.enums.DifficultyLevel;
import com.example.demo.enums.TypeOfTour;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.List;
@Entity
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @ManyToOne
    private Groups groups;
    @ManyToOne
    private Instructor instructor;
    @Enumerated(EnumType.STRING)
    private DifficultyLevel difficultyLevel;
    private int countOfBerths;
    private LocalTime time;
    @Enumerated(EnumType.STRING)
    private TypeOfTour typeOfTour;
    @ManyToOne
    private Route route;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "tour_tourist",
            joinColumns = @JoinColumn(name = "tour_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "tourist_id", referencedColumnName = "id"))
    List<Tourist> tourists;

    public Tour() {
    }

    public Tour(int id, String name, Groups groups, Instructor instructor, DifficultyLevel difficultyLevel, int countOfBerths, LocalTime time, TypeOfTour typeOfTour, Route route) {
        this.id = id;
        this.name = name;
        this.groups = groups;
        this.instructor = instructor;
        this.difficultyLevel = difficultyLevel;
        this.countOfBerths = countOfBerths;
        this.time = time;
        this.typeOfTour = typeOfTour;
        this.route = route;
    }

    public Tour(int id, String name, Groups groups, Instructor instructor, DifficultyLevel difficultyLevel, int countOfBerths, LocalTime time, TypeOfTour typeOfTour, Route route, List<Tourist> tourists) {

        this.id = id;
        this.name = name;
        this.groups = groups;
        this.instructor = instructor;
        this.difficultyLevel = difficultyLevel;
        this.countOfBerths = countOfBerths;
        this.time = time;
        this.typeOfTour = typeOfTour;
        this.route = route;
        this.tourists = tourists;
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

    public Groups getGroups() {
        return groups;
    }

    public void setGroups(Groups groups) {
        this.groups = groups;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public DifficultyLevel getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(DifficultyLevel difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    public int getCountOfBerths() {
        return countOfBerths;
    }

    public void setCountOfBerths(int countOfBerths) {
        this.countOfBerths = countOfBerths;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public TypeOfTour getTypeOfTour() {
        return typeOfTour;
    }

    public void setTypeOfTour(TypeOfTour typeOfTour) {
        this.typeOfTour = typeOfTour;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public List<Tourist> getTourists() {
        return tourists;
    }

    public void setTourists(List<Tourist> tourists) {
        this.tourists = tourists;
    }
}
