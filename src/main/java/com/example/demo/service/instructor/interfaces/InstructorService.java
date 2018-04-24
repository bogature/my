package com.example.demo.service.instructor.interfaces;

import com.example.demo.model.Instructor;
import com.example.demo.model.Tourist;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface InstructorService {
    public Instructor insert(Instructor instructor);
    public Instructor update(Instructor instructor);
    public Instructor delete(int id);
    public Instructor getInstructorById(int id);
    public Instructor getInstructorByName(String name);
    public List<Instructor> getAll();
}
