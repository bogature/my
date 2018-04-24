package com.example.demo.dao.route;


import com.example.demo.dao.GeneralDao;
import com.example.demo.datastorage.DataStorageFake;
import com.example.demo.model.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class RouteDaoFakeJDBCImpl implements GeneralDao<Route> {
    @Autowired
    DataStorageFake dataStorageFake;

    @Override
    public Route insert() {
        return null;
    }

    @Override
    public Route update() {
        return null;
    }

    @Override
    public Route delete() {
        return null;
    }

    @Override
    public List<Route> getAll() {
        return dataStorageFake.getRoutes();
    }
}
