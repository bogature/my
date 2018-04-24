package com.example.demo.model;

import javax.persistence.*;
import java.time.LocalTime;
@Entity
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private Section section;
    private int count;
    private String place;
    private LocalTime time;

    public Schedule() {
    }

    public Schedule(int id, Section section, int count, String place, LocalTime time) {
        this.id = id;
        this.section = section;
        this.count = count;
        this.place = place;
        this.time = time;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }
}
