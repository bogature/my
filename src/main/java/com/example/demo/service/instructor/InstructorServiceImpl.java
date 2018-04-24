package com.example.demo.service.instructor;

import com.example.demo.dao.instructor.InstructorDaoFakeJDBCImpl;
import com.example.demo.model.Instructor;
import com.example.demo.service.interfaces.GeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class InstructorServiceImpl implements GeneralService<Instructor> {
    @Autowired
    InstructorDaoFakeJDBCImpl instructorDaoFakeJDBC;

    @Override
    public List<Instructor> getAll() {
        return instructorDaoFakeJDBC.getAll();
    }
}
