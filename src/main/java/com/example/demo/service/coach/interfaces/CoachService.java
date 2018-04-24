package com.example.demo.service.coach.interfaces;

import com.example.demo.model.Coach;
import com.example.demo.model.Tourist;

import java.util.List;

public interface CoachService {
    public Coach insert(Coach coach);
    public Coach update(Coach coach);
    public Coach delete(int id);
    public Coach getCoachById(int id);
    public Coach getCoachByName(String name);
    public List<Coach> getAll();
}
