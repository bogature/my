package com.example.demo.controller;

import com.example.demo.model.Instructor;
import com.example.demo.service.instructor.InstructorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/instructors")
public class InstructorController {
    @Autowired
    InstructorServiceImpl instructorService;


    @PostMapping("/insert")
    public Instructor insertInstructor( @RequestBody Instructor instructor){
        return instructorService.insert(instructor);
    }

    @PostMapping("/update")
    public Instructor updateInstructor(@RequestBody Instructor instructor ,@RequestParam("id") int id){
        instructor.setId(id);
        return instructorService.update(instructor);
    }

    @GetMapping("/getById")
    public Instructor getInstructorById(@RequestParam ("id") int id){
        return instructorService.getInstructorById(id);
    }

    @DeleteMapping("/delete")
    public void deleteInstructor(@RequestParam ("id") int id){
        instructorService.delete(id);
    }

    @GetMapping("/getAll")
    public List<Instructor> getAllInstructor(){
        return instructorService.getAll();
    }

}
