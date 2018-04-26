package com.example.demo.service.competition;

import com.example.demo.model.Competition;
import com.example.demo.repository.CompetitionRepository;
import com.example.demo.service.competition.interfaces.CompetitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompetitionServiceImpl implements CompetitionService {
    @Autowired
    CompetitionRepository competitionRepository;

    @Override
    public Competition insert(Competition competition) {
        return competitionRepository.save(competition);
    }

    @Override
    public Competition update(Competition competition) {
        return competitionRepository.save(competition);
    }

    @Override
    public void delete(int id) {
        competitionRepository.deleteById(id);
    }

    @Override
    public Competition getCompetitionById(int id) {
        return competitionRepository.findById(id).get();
    }

    @Override
    public Competition getCompetitionByName(String name) {
        return null;
    }

    @Override
    public List<Competition> getAll() {
        return competitionRepository.findAll();
    }
}
