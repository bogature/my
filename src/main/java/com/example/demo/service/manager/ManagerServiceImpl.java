package com.example.demo.service.manager;

import com.example.demo.dao.manager.ManagerDaoFakeJDBCImpl;
import com.example.demo.model.Manager;
import com.example.demo.service.interfaces.GeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerServiceImpl implements GeneralService<Manager> {
    @Autowired
    ManagerDaoFakeJDBCImpl managerDaoFakeJDBC;

    @Override
    public List<Manager> getAll() {
        return managerDaoFakeJDBC.getAll();
    }
}
