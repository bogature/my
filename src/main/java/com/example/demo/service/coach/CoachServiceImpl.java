package com.example.demo.service.coach;

import com.example.demo.dao.coach.CoachDaoFakeJDBCImpl;
import com.example.demo.model.Coach;
import com.example.demo.service.interfaces.GeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoachServiceImpl implements GeneralService<Coach> {
    @Autowired
    CoachDaoFakeJDBCImpl coachDaoFakeJDBC;
    @Override
    public List<Coach> getAll() {
        return coachDaoFakeJDBC.getAll();
    }
}
