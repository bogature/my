package com.example.demo.controller;

import com.example.demo.model.Coach;
import com.example.demo.service.coach.CoachServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coaches")
public class CoachController {
    @Autowired
    CoachServiceImpl coachService;

    @PostMapping("/insert")
    public Coach insertCoach( @RequestParam ("coach") Coach coach){
        return coachService.insert(coach);
    }

    @PostMapping("/update")
    public Coach updateCoach(@RequestParam ("coach") Coach coach){
        return coachService.update(coach);
    }

    @GetMapping("/getById")
    public Coach getCoachById(@RequestParam ("id") int id){
        return coachService.getCoachById(id);
    }

    @DeleteMapping("/delete")
    public void deleteCoach(@RequestParam ("id") int id){
        coachService.delete(id);
    }

    @GetMapping("/getAll")
    public List<Coach> getAllcoaches(){
        return coachService.getAll();
    }
}
