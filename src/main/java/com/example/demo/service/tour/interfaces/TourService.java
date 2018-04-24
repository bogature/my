package com.example.demo.service.tour.interfaces;

import com.example.demo.model.Tour;

import java.util.List;

public interface TourService {
    public Tour insert(Tour tour);
    public Tour update(Tour tour);
    public void delete(int id);
    public Tour getTourById(int id);
    public Tour getTourByName(String name);
    public List<Tour> getAll();
}
