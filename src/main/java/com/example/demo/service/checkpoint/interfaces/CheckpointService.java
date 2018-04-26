package com.example.demo.service.checkpoint.interfaces;

import com.example.demo.model.Checkpoint;

import java.util.List;

public interface CheckpointService {
    public Checkpoint insert(Checkpoint checkpoint);
    public Checkpoint update(Checkpoint checkpoint);
    public void delete(int id);
    public Checkpoint getCheckpointById(int id);
    public Checkpoint getCheckpointByName(String name);
    public List<Checkpoint> getAll();
}
