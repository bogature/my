package com.example.demo.service.coach.interfaces;

import com.example.demo.model.Coach;

import java.util.List;

public interface CoachService {
    public Coach insert(Coach coach);
    public Coach update(Coach coach);
    public void delete(int id);
    public Coach getCoachById(int id);
    public Coach getCoachByName(String name);
    public List<Coach> getAll();
}
