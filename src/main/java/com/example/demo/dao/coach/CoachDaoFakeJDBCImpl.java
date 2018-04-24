package com.example.demo.dao.coach;

import com.example.demo.dao.GeneralDao;
import com.example.demo.datastorage.DataStorageFake;
import com.example.demo.model.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CoachDaoFakeJDBCImpl implements GeneralDao<Coach> {
    @Autowired
    DataStorageFake dataStorageFake;

    @Override
    public Coach insert() {
        return null;
    }

    @Override
    public Coach update() {
        return null;
    }

    @Override
    public Coach delete() {
        return null;
    }

    @Override
    public List<Coach> getAll() {
        return dataStorageFake.getCoaches();
    }
}
