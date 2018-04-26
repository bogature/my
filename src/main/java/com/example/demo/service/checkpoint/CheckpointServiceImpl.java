package com.example.demo.service.checkpoint;

import com.example.demo.model.Checkpoint;
import com.example.demo.repository.CheckpointRepository;
import com.example.demo.service.checkpoint.interfaces.CheckpointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckpointServiceImpl implements CheckpointService {
    @Autowired
    CheckpointRepository checkpointRepository;


    @Override
    public Checkpoint insert(Checkpoint checkpoint) {
        return checkpointRepository.save(checkpoint);
    }

    @Override
    public Checkpoint update(Checkpoint checkpoint) {
        return checkpointRepository.save(checkpoint);
    }

    @Override
    public void delete(int id) {
        checkpointRepository.deleteById(id);
    }

    @Override
    public Checkpoint getCheckpointById(int id) {
        return checkpointRepository.findById(id).get();
    }

    @Override
    public Checkpoint getCheckpointByName(String name) {
        return null;
    }

    @Override
    public List<Checkpoint> getAll() {
        return checkpointRepository.findAll();
    }
}
