package com.example.demo.dao.schedule;


import com.example.demo.dao.GeneralDao;
import com.example.demo.datastorage.DataStorageFake;
import com.example.demo.model.Schedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class ScheduleDaoFakeJDBCImpl implements GeneralDao<Schedule> {
    @Autowired
    DataStorageFake dataStorageFake;

    @Override
    public Schedule insert() {
        return null;
    }

    @Override
    public Schedule update() {
        return null;
    }

    @Override
    public Schedule delete() {
        return null;
    }

    @Override
    public List<Schedule> getAll() {
        return dataStorageFake.getSchedules();
    }
}
