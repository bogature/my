package com.example.demo.controller;

import com.example.demo.model.Tourist;
import com.example.demo.service.tourist.TouristServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TouristController  {
    @Autowired
    TouristServiceImpl touristService;

    @GetMapping("/getAllTourists")
    public List<Tourist> getAllTourists(){
        return touristService.getAll();
    }
}
