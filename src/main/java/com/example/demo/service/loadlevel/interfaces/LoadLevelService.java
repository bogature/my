package com.example.demo.service.loadlevel.interfaces;

import com.example.demo.model.LoadLevel;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface LoadLevelService {
    public LoadLevel insert(LoadLevel loadLevel);
    public LoadLevel update(LoadLevel loadLevel);
    public void delete(int id);
    public LoadLevel getLoadLevelById(int id);
    public LoadLevel getLoadLevelByName(String name);
    public List<LoadLevel> getAll();
}
