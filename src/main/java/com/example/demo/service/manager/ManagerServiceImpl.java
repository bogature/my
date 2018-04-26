package com.example.demo.service.manager;

import com.example.demo.model.Manager;
import com.example.demo.repository.ManagerRepository;
import com.example.demo.service.manager.interfaces.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerServiceImpl implements ManagerService {
    @Autowired
    ManagerRepository managerRepository;

    @Override
    public Manager insert(Manager manager) {
        return managerRepository.save(manager);
    }

    @Override
    public Manager update(Manager manager) {
        return managerRepository.save(manager);
    }

    @Override
    public void delete(int id) {
         managerRepository.deleteById(id);
    }

    @Override
    public Manager getManagerById(int id) {
        return managerRepository.findById(id).get();
    }

    @Override
    public Manager getManagerByName(String name) {
        return null;
    }

    @Override
    public List<Manager> getAll() {
        return managerRepository.findAll();
    }
}
