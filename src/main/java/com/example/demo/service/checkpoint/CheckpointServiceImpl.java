package com.example.demo.service.checkpoint;

import com.example.demo.dao.checkpoint.CheckpointDaoFakeJDBCImpl;
import com.example.demo.model.Checkpoint;
import com.example.demo.service.interfaces.GeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckpointServiceImpl implements GeneralService<Checkpoint> {
    @Autowired
    CheckpointDaoFakeJDBCImpl checkpointDaoFakeJDBC;

    @Override
    public List<Checkpoint> getAll() {
        return checkpointDaoFakeJDBC.getAll();
    }
}
