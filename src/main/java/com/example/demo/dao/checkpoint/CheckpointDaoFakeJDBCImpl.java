package com.example.demo.dao.checkpoint;

import com.example.demo.dao.GeneralDao;
import com.example.demo.datastorage.DataStorageFake;
import com.example.demo.model.Checkpoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CheckpointDaoFakeJDBCImpl implements GeneralDao<Checkpoint> {
    @Autowired
    DataStorageFake dataStorageFake;

    @Override
    public Checkpoint insert() {
        return null;
    }

    @Override
    public Checkpoint update() {
        return null;
    }

    @Override
    public Checkpoint delete() {
        return null;
    }

    @Override
    public List<Checkpoint> getAll() {
        return dataStorageFake.getCheckpoints();
    }
}
