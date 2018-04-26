package com.example.demo.controller;

import com.example.demo.datastorage.DataStorageFake;
import com.example.demo.model.Tourist;
import com.example.demo.service.tourist.TouristServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tourists")
public class TouristController  {
    @Autowired
    TouristServiceImpl touristService;

    DataStorageFake dataStorageFake;

    @PostMapping("/insert")
    public Tourist insertTourist( @RequestBody Tourist group){
        return touristService.insert(group);
    }

    @PostMapping("/update")
    public Tourist updateTourist(@RequestBody  Tourist group){
        return touristService.update(group);
    }

    @GetMapping("/getById")
    public Tourist getGroupById(@RequestParam ("id") int id){
        return touristService.getTouristById(id);
    }

    @DeleteMapping("/delete")
    public void deleteTourist(@RequestParam ("id") int id){
        touristService.delete(id);
    }

    @GetMapping("/getAll")
    public List<Tourist> getAllTourists(){
       // dataStorageFake.getTourists();
        return touristService.getAll();
    }
}
