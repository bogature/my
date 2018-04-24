package com.example.demo.dao.section;


import com.example.demo.dao.GeneralDao;
import com.example.demo.datastorage.DataStorageFake;
import com.example.demo.model.Section;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class SectionDaoFakeJDBCImpl implements GeneralDao<Section> {
   @Autowired
    DataStorageFake dataStorageFake;

    @Override
    public Section insert() {
        return null;
    }

    @Override
    public Section update() {
        return null;
    }

    @Override
    public Section delete() {
        return null;
    }

    @Override
    public List<Section> getAll() {
        return dataStorageFake.getSections();
    }
}
