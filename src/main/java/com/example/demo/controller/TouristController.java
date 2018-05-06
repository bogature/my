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

    @PostMapping("/insert")
    public Tourist insertTourist( @RequestBody Tourist tourist){
        return touristService.insert(tourist);
    }

    @PostMapping("/update")
    public Tourist updateTourist(@RequestBody Tourist tourist ,@RequestParam("id") int id){
        tourist.setId(id);
        return touristService.update(tourist);
    }

    @GetMapping("/getById")
    public Tourist getTouristById(@RequestParam ("id") int id){
        return touristService.getTouristById(id);
    }

    @DeleteMapping("/delete")
    public void deleteTourist(@RequestParam ("id") int id){
        touristService.delete(id);
    }

    @GetMapping("/getAll")
    public List<Tourist> getAllTourists(){
        return touristService.getAll();
    }
}
