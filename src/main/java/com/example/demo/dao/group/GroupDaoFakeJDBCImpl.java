package com.example.demo.dao.group;

import com.example.demo.dao.GeneralDao;
import com.example.demo.datastorage.DataStorageFake;
import com.example.demo.model.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GroupDaoFakeJDBCImpl implements GeneralDao<Group> {
    @Autowired
    DataStorageFake dataStorageFake;


    @Override
    public Group insert() {
        return null;
    }

    @Override
    public Group update() {
        return null;
    }

    @Override
    public Group delete() {
        return null;
    }

    @Override
    public List<Group> getAll() {
        return dataStorageFake.getGroups();
    }
}
