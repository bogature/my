package com.example.demo.controller;

import com.example.demo.model.Checkpoint;
import com.example.demo.service.checkpoint.CheckpointServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CheckpointController {
    @Autowired
    CheckpointServiceImpl checkpointService;

    @GetMapping("/getAllChechpoints")
    public List<Checkpoint> getAllCheckpoints(){
        return checkpointService.getAll();
    }
}
