package com.example.demo.controller;

import com.example.demo.model.Instructor;
import com.example.demo.service.instructor.InstructorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class InstructorController {
    @Autowired
    InstructorServiceImpl instructorService;

    @GetMapping("/getAllInstructors")
    public List<Instructor> getAllInstructor(){
        return instructorService.getAll();
    }

}
