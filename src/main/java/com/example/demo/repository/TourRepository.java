package com.example.demo.repository;

import com.example.demo.model.Tour;
import com.example.demo.model.Tourist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TourRepository extends JpaRepository<Tour,Integer> {
}
