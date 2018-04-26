package com.example.demo.service.coach;

import com.example.demo.model.Coach;
import com.example.demo.repository.CoachRepository;
import com.example.demo.service.coach.interfaces.CoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoachServiceImpl implements CoachService {
    @Autowired
    CoachRepository coachRepository;

    @Override
    public Coach insert(Coach coach) {
        return coachRepository.save(coach);
    }

    @Override
    public Coach update(Coach coach) {
        return coachRepository.save(coach);
    }

    @Override
    public void delete(int id) {
        coachRepository.deleteById(id);
    }

    @Override
    public Coach getCoachById(int id) {
        return coachRepository.findById(id).get();
    }

    @Override
    public Coach getCoachByName(String name) {
        return null;
    }

    @Override
    public List<Coach> getAll() {
        return coachRepository.findAll();
    }
}
