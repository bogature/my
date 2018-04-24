package com.example.demo.dao.tour;


import com.example.demo.dao.GeneralDao;
import com.example.demo.datastorage.DataStorageFake;
import com.example.demo.model.Tour;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class TourDaoFakeJDBCImpl implements GeneralDao<Tour> {
    @Autowired
    DataStorageFake dataStorageFake;

    @Override
    public Tour insert() {
        return null;
    }

    @Override
    public Tour update() {
        return null;
    }

    @Override
    public Tour delete() {
        return null;
    }

    @Override
    public List<Tour> getAll() {
        return dataStorageFake.getTours();
    }
}
