package com.example.demo.service.group;

import com.example.demo.dao.group.GroupDaoFakeJDBCImpl;
import com.example.demo.model.Group;
import com.example.demo.service.interfaces.GeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupServiceImpl implements GeneralService<Group> {
    @Autowired
    GroupDaoFakeJDBCImpl groupDaoFakeJDBC;

    @Override
    public List<Group> getAll() {
        return groupDaoFakeJDBC.getAll();
    }
}
