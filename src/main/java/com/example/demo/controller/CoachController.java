package com.example.demo.controller;

import com.example.demo.model.Coach;
import com.example.demo.service.coach.CoachServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CoachController {
    @Autowired
    CoachServiceImpl coachService;

    @GetMapping("/getAllCoaches")
    public List<Coach> getAllcoaches(){
        return coachService.getAll();
    }
}
