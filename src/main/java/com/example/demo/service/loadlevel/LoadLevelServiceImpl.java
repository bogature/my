package com.example.demo.service.loadlevel;

import com.example.demo.model.LoadLevel;
import com.example.demo.repository.LoadLevelRepository;
import com.example.demo.service.loadlevel.interfaces.LoadLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LoadLevelServiceImpl  implements LoadLevelService{
    @Autowired
    LoadLevelRepository loadLevelRepository;

    @Override
    public LoadLevel insert(LoadLevel loadLevel) {
        return loadLevelRepository.save(loadLevel);
    }

    @Override
    public LoadLevel update(LoadLevel loadLevel) {
        return loadLevelRepository.save(loadLevel);
    }

    @Override
    public void delete(int id) {
        loadLevelRepository.deleteById(id);
    }

    @Override
    public LoadLevel getLoadLevelById(int id) {
        return loadLevelRepository.findById(id).get();
    }

    @Override
    public LoadLevel getLoadLevelByName(String name) {
        return null;
    }

    @Override
    public List<LoadLevel> getAll() {
        return loadLevelRepository.findAll();
    }
}
