package com.example.demo.service.tourist;

import com.example.demo.dao.tourist.TouristDaoFakeJDBCImpl;
import com.example.demo.enums.TypeOfTourist;
import com.example.demo.model.Tourist;
import com.example.demo.repository.TouristRepository;
import com.example.demo.service.tourist.interfaces.TouristService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TouristServiceImpl implements TouristService{
    @Autowired
    TouristRepository touristRepository;

    @Override
    public Tourist insert(Tourist tourist) {
       return touristRepository.save(tourist);
    }

    @Override
    public Tourist update(Tourist tourist) {
        return touristRepository.save(tourist);
    }

    @Override
    public void delete(int id) {
        touristRepository.deleteById(id);
    }

    @Override
    public Tourist getTouristById(int id) {
        return touristRepository.findById(id).get();
    }

    @Override
    public List<Tourist> getAll() {
        return touristRepository.findAll();
    }

    public List<Tourist> getTouristByGroup(int group_id) {
        return touristRepository.getTouristByGroup(group_id);
    }

    public int getCountTouristByGroup(int group_id) {
        return touristRepository.getCountTouristByGroup(group_id);
    }

    public int getCountTouristByAge(int age) {
        return touristRepository.getCountTouristByAge(age);
    }

    public List<Tourist> getTouristByAge(int age) {
        return touristRepository.getTouristByAge(age);
    }

    public List<Tourist> getTouristByType(TypeOfTourist type_id) {
        return touristRepository.getTouristByType(type_id);
    }

    public int getCountTouristByType(TypeOfTourist type_id) {
        return touristRepository.getCountTouristByType(type_id);
    }


}
