package com.example.demo.controller;

import com.example.demo.model.Checkpoint;
import com.example.demo.service.checkpoint.CheckpointServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/checkpoints")
public class CheckpointController {
    @Autowired
    CheckpointServiceImpl checkpointService;

    @PostMapping("/insert")
    public Checkpoint insertCheckpoint( @RequestBody Checkpoint checkpoint){
        return checkpointService.insert(checkpoint);
    }

    @PostMapping("/update")
    public Checkpoint updateCheckpoint(@RequestBody Checkpoint checkpoint){
        return checkpointService.update(checkpoint);
    }

    @GetMapping("/getById")
    public Checkpoint getCheckpointById(@RequestParam ("id") int id){
        return checkpointService.getCheckpointById(id);
    }

    @DeleteMapping("/delete")
    public void deleteCheckpoint(@RequestParam ("id") int id){
        checkpointService.delete(id);
    }

    @GetMapping("/getAll")
    public List<Checkpoint> getAllCheckpoints(){
        return checkpointService.getAll();
    }
}
