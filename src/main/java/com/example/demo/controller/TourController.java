package com.example.demo.controller;

import com.example.demo.model.Tour;
import com.example.demo.service.tour.TourServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tours")
public class TourController {
    @Autowired
    TourServiceImpl tourService;

    @PostMapping("/insert")
    public Tour insertTour( @RequestBody Tour tour){
       // System.out.println(tour.toString());
        return tourService.insert(tour);
    }

    @PostMapping("/update")
    public Tour updateTour(@RequestBody Tour coach ,@RequestParam("id") int id){
        coach.setId(id);
        return tourService.update(coach);
    }

    @GetMapping("/getById")
    public Tour getTourById(@RequestParam ("id") int id){
        return tourService.getTourById(id);
    }

    @DeleteMapping("/delete")
    public void deleteTour(@RequestParam ("id") int id){
        tourService.delete(id);
    }

    @GetMapping("/getAll")
    public List<Tour> getAllTours(){
        return tourService.getAll();
    }
}
