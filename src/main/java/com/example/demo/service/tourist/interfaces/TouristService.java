package com.example.demo.service.tourist.interfaces;

import com.example.demo.model.Tourist;

import java.util.List;

public interface TouristService  {
    public Tourist insert(Tourist tourist);
    public Tourist update(Tourist tourist);
    public void delete(int id);
    public Tourist getTouristById(int id);
    public List<Tourist> getAll();
}
