package com.example.demo.service.tour;

import com.example.demo.model.Tour;
import com.example.demo.repository.TourRepository;
import com.example.demo.service.tour.interfaces.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TourServiceImpl implements TourService {
    @Autowired
    TourRepository tourRepository;


    @Override
    public Tour insert(Tour tour) {
        return tourRepository.saveAndFlush(tour);
    }

    @Override
    public Tour update(Tour tour) {
        return tourRepository.save(tour);
    }

    @Override
    public void delete(int id) {
         tourRepository.deleteById(id);
    }

    @Override
    public Tour getTourById(int id) {
        return tourRepository.findById(id).get();
    }

    @Override
    public Tour getTourByName(String name) {
        return null;
    }

    @Override
    public List<Tour> getAll() {
        return tourRepository.findAll();
    }
}
