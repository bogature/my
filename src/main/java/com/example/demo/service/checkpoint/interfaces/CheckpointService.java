package com.example.demo.service.checkpoint.interfaces;

import com.example.demo.model.Checkpoint;
import com.example.demo.model.Tourist;

import java.util.List;

public interface CheckpointService {
    public Checkpoint insert(Checkpoint checkpoint);
    public Checkpoint update(Checkpoint checkpoint);
    public Checkpoint delete(int id);
    public Checkpoint getCheckpointById(int id);
    public Checkpoint getCheckpointByName(String name);
    public List<Checkpoint> getAll();
}
