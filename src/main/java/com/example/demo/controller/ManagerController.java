package com.example.demo.controller;

import com.example.demo.model.Manager;
import com.example.demo.service.manager.ManagerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/managers")
public class ManagerController {
    @Autowired
    ManagerServiceImpl managerService;

    @PostMapping("/insert")
    public Manager insertManager( @RequestBody Manager manager){
        return managerService.insert(manager);
    }

    @PostMapping("/update")
    public Manager updateManager(@RequestBody Manager manager,@RequestParam("id") int id) {
        manager.setId(id);
        return managerService.update(manager);
    }

    @GetMapping("/getById")
    public Manager getManagerById(@RequestParam ("id") int id){
        return managerService.getManagerById(id);
    }

    @DeleteMapping("/delete")
    public void deleteManager(@RequestParam ("id") int id){
        managerService.delete(id);
    }

    @GetMapping("/getAll")
    public List<Manager> getAllManagers(){
        return managerService.getAll();
    }
}
