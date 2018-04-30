package com.example.demo.controller;

import com.example.demo.model.LoadLevel;
import com.example.demo.service.loadlevel.LoadLevelServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loadLevels")
public class LoadLevelController {
    @Autowired
    LoadLevelServiceImpl loadLevelService;

    @PostMapping("/insert")
    public LoadLevel insertLoadLevel( @RequestBody LoadLevel loadLevel){
        return loadLevelService.insert(loadLevel);
    }

    @PostMapping("/update")
    public LoadLevel updateLoadLevel(@RequestBody LoadLevel loadLevel,@RequestParam("id") int id) {
        loadLevel.setId(id);
        return loadLevelService.update(loadLevel);
    }

    @GetMapping("/getById")
    public LoadLevel getLoadLevelById(@RequestParam ("id") int id){
        return loadLevelService.getLoadLevelById(id);
    }

    @DeleteMapping("/delete")
    public void deleteLoadLevel(@RequestParam ("id") int id){
        loadLevelService.delete(id);
    }

    @GetMapping("/getAll")
    public List<LoadLevel> getAllLoadLevels(){
        return loadLevelService.getAll();
    }
}
