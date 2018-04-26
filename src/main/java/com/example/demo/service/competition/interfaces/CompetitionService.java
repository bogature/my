package com.example.demo.service.competition.interfaces;

import com.example.demo.model.Competition;

import java.util.List;

public interface CompetitionService {
    public Competition insert(Competition competition);
    public Competition update(Competition competition);
    public void delete(int id);
    public Competition getCompetitionById(int id);
    public Competition getCompetitionByName(String name);
    public List<Competition> getAll();
}
