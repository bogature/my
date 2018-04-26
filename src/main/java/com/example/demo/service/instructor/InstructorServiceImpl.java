package com.example.demo.service.instructor;

import com.example.demo.model.Instructor;
import com.example.demo.repository.InstructorRepository;
import com.example.demo.service.instructor.interfaces.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class InstructorServiceImpl implements InstructorService {
    @Autowired
    InstructorRepository instructorRepository;

    @Override
    public Instructor insert(Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    @Override
    public Instructor update(Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    @Override
    public void delete(int id) {
         instructorRepository.deleteById(id);
    }

    @Override
    public Instructor getInstructorById(int id) {
        return instructorRepository.findById(id).get();
    }

    @Override
    public Instructor getInstructorByName(String name) {
        return null;
    }

    @Override
    public List<Instructor> getAll() {
        return instructorRepository.findAll();
    }
}
