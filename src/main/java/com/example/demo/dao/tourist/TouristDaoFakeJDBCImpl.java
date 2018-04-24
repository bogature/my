package com.example.demo.dao.tourist;


import com.example.demo.dao.GeneralDao;
import com.example.demo.datastorage.DataStorageFake;
import com.example.demo.model.Tourist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class TouristDaoFakeJDBCImpl implements GeneralDao<Tourist> {
    @Autowired
    DataStorageFake dataStorageFake;

    @Override
    public Tourist insert() {
        return null;
    }

    @Override
    public Tourist update() {
        return null;
    }

    @Override
    public Tourist delete() {
        return null;
    }

    @Override
    public List<Tourist> getAll() {
        return dataStorageFake.getTourists();
    }
}
