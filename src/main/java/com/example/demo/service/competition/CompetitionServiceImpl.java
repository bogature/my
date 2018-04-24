package com.example.demo.service.competition;

import com.example.demo.dao.competition.CompetitionDaoFakeJDBCImpl;
import com.example.demo.datastorage.DataStorageFake;
import com.example.demo.model.Competition;
import com.example.demo.service.interfaces.GeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompetitionServiceImpl implements GeneralService<Competition> {
    @Autowired
    CompetitionDaoFakeJDBCImpl competitionDaoFakeJDBC;

    @Override
    public List<Competition> getAll() {
        return competitionDaoFakeJDBC.getAll();
    }
}
