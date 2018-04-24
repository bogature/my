package com.example.demo.dao.manager;

import com.example.demo.dao.GeneralDao;
import com.example.demo.datastorage.DataStorageFake;
import com.example.demo.model.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManagerDaoFakeJDBCImpl implements GeneralDao<Manager> {
    @Autowired
    DataStorageFake dataStorageFake;

    @Override
    public Manager insert() {
        return null;
    }

    @Override
    public Manager update() {
        return null;
    }

    @Override
    public Manager delete() {
        return null;
    }

    @Override
    public List<Manager> getAll() {
        return dataStorageFake.getManagers();
    }
}
