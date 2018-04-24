package com.example.demo.dao.instructor;

import com.example.demo.dao.GeneralDao;
import com.example.demo.datastorage.DataStorageFake;
import com.example.demo.model.Instructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InstructorDaoFakeJDBCImpl implements GeneralDao<Instructor> {
    @Autowired
    DataStorageFake dataStorageFake;

    @Override
    public Instructor insert() {
        return null;
    }

    @Override
    public Instructor update() {
        return null;
    }

    @Override
    public Instructor delete() {
        return null;
    }

    @Override
    public List<Instructor> getAll() {
        return dataStorageFake.getInstructors();
    }
}
