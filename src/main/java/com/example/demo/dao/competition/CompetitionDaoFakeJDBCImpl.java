package com.example.demo.dao.competition;

import com.example.demo.dao.GeneralDao;
import com.example.demo.datastorage.DataStorageFake;
import com.example.demo.model.Competition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CompetitionDaoFakeJDBCImpl implements GeneralDao<Competition> {
    @Autowired
    DataStorageFake dataStorageFake;

    @Override
    public Competition insert() {
        return null;
    }

    @Override
    public Competition update() {
        return null;
    }

    @Override
    public Competition delete() {
        return null;
    }

    @Override
    public List<Competition> getAll() {
        return dataStorageFake.getCompetitions();
    }
}
