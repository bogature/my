package com.example.demo.dao.group;

import com.example.demo.dao.GeneralDao;
import com.example.demo.datastorage.DataStorageFake;
import com.example.demo.model.Groups;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GroupDaoFakeJDBCImpl implements GeneralDao<Groups> {
    @Autowired
    DataStorageFake dataStorageFake;


    @Override
    public Groups insert() {
        return null;
    }

    @Override
    public Groups update() {
        return null;
    }

    @Override
    public Groups delete() {
        return null;
    }

    @Override
    public List<Groups> getAll() {
      //  return dataStorageFake.getGroups();
        return null;
    }
}
