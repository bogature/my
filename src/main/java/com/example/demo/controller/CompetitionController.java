package com.example.demo.controller;

import com.example.demo.model.Competition;
import com.example.demo.service.competition.CompetitionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/competitions")
public class CompetitionController {
    @Autowired
    CompetitionServiceImpl competitionService;

    @PostMapping("/insert")
    public Competition insertCompetition(@RequestBody Competition competition){
        return competitionService.insert(competition);
    }

    @PostMapping("/update")
    public Competition updateCompetition(@RequestBody Competition competition ,@RequestParam("id") int id){
        competition.setId(id);
        return competitionService.update(competition);
    }

    @GetMapping("/getById")
    public Competition getCompetitionById(@RequestParam ("id") int id){
        return competitionService.getCompetitionById(id);
    }

    @DeleteMapping("/delete")
    public void deleteCompetition(@RequestParam ("id") int id){
        competitionService.delete(id);
    }

    @GetMapping("/getAll")
    public List<Competition> getAllCompetitions(){
        return competitionService.getAll();
    }
}
