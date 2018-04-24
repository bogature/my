package com.example.demo.controller;

import com.example.demo.model.Manager;
import com.example.demo.service.manager.ManagerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ManagerController {
    @Autowired
    ManagerServiceImpl managerService;

    @GetMapping("/getAllManagers")
    public List<Manager> getAllManagers(){
        return managerService.getAll();
    }
}
