package com.example.demo.service.manager.interfaces;

import com.example.demo.model.Manager;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ManagerService {
    public Manager insert(Manager manager);
    public Manager update(Manager manager);
    public void delete(int id);
    public Manager getManagerById(int id);
    public Manager getManagerByName(String name);
    public List<Manager> getAll();
}
